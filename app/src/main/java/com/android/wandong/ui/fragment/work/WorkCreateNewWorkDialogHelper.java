package com.android.wandong.ui.fragment.work;

import android.app.Activity;
import android.app.Dialog;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.wandong.R;
import com.android.wandong.base.BaseResponseBean;
import com.android.wandong.network.ApiUrls;
import com.android.wandong.ui.widget.CircleView;
import com.android.wandong.ui.widget.FixGridView;
import com.android.wandong.ui.widget.FixViewPager;
import com.android.wandong.utils.Tools;
import com.zhan.framework.network.HttpRequestHandler;
import com.zhan.framework.network.HttpRequestParams;
import com.zhan.framework.network.HttpRequestUtils;
import com.zhan.framework.support.adapter.ABaseAdapter;
import com.zhan.framework.support.inject.InjectUtility;
import com.zhan.framework.support.inject.ViewInject;
import com.zhan.framework.ui.widget.ActionSheetDialog;
import com.zhan.framework.utils.PixelUtils;
import com.zhan.framework.utils.ToastUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/**
 * 作者：伍岳 on 2016/8/7 00:27
 * 邮箱：wuyue8512@163.com
 * //
 * //         .............................................
 * //                  美女坐镇                  BUG辟易
 * //         .............................................
 * //
 * //                       .::::.
 * //                     .::::::::.
 * //                    :::::::::::
 * //                 ..:::::::::::'
 * //              '::::::::::::'
 * //                .::::::::::
 * //           '::::::::::::::..
 * //                ..::::::::::::.
 * //              ``::::::::::::::::
 * //               ::::``:::::::::'        .:::.
 * //              ::::'   ':::::'       .::::::::.
 * //            .::::'      ::::     .:::::::'::::.
 * //           .:::'       :::::  .:::::::::' ':::::.
 * //          .::'        :::::.:::::::::'      ':::::.
 * //         .::'         ::::::::::::::'         ``::::.
 * //     ...:::           ::::::::::::'              ``::.
 * //    ```` ':.          ':::::::::'                  ::::..
 * //                       '.:::::'                    ':'````..
 * //
 */
public class WorkCreateNewWorkDialogHelper implements AdapterView.OnItemClickListener {
    private Dialog mDialog;
    private Activity mActivity;

    @ViewInject(id = R.id.wrapContentHeightViewPager)
    FixViewPager mFixViewPager;

    @ViewInject(id = R.id.close_btn, click = "OnClick")
    View mViewQuit;

    @ViewInject(id = R.id.date)
    TextView mTextViewDate;

    @ViewInject(id = R.id.month)
    TextView mTextViewMonth;

    @ViewInject(id = R.id.indicator)
    LinearLayout mContainerIndicator;

    private ArrayList<WorkMain.WorkCategoryItem> mTabs;

    private List<ArrayList<WorkMain.WorkCategoryItem>> mPageDataList = new ArrayList<>();

    public WorkCreateNewWorkDialogHelper(Activity activity, ArrayList<WorkMain.WorkCategoryItem> tabs) {
        mTabs = tabs;
        mActivity = activity;
        mDialog = new Dialog(activity, R.style.Dialog_Fullscreen);
        View content = activity.getLayoutInflater().inflate(R.layout.dialog_create_work_item, null);
        InjectUtility.initInjectedView(this, content);
        mDialog.setContentView(content);


        Calendar calendar = Calendar.getInstance();
        mTextViewDate.setText(String.format("%02d", calendar.get(Calendar.DAY_OF_MONTH)));

        DateFormat df = new SimpleDateFormat("MMMM", Locale.ENGLISH);
        mTextViewMonth.setText(df.format(new Date()));

        mFixViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < mContainerIndicator.getChildCount(); i++) {
                    CircleView circleView = (CircleView) mContainerIndicator.getChildAt(i);
                    if (position == i) {
                        circleView.setDrawColor(0xff996633);
                    } else {
                        circleView.setDrawColor(0xffAAAAAA);
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public void showDialog() {
        mPageDataList.clear();
        mContainerIndicator.removeAllViews();

        List<View> listViews = new ArrayList<>();
        ArrayList<WorkMain.WorkCategoryItem> pageData = new ArrayList<>();
        for (int i = 0; i < mTabs.size(); i++) {
            WorkMain.WorkCategoryItem tabItem= mTabs.get(i);
            if(MyAuditListFragment.TAB_TYPE.equals(tabItem.getType())){
                continue;
            }
            if (pageData.size() % 9 == 0) {
                pageData = new ArrayList<>();
                mPageDataList.add(pageData);
            }
            pageData.add(tabItem);
        }

        for (int i = 0; i < mPageDataList.size(); i++) {
            FixGridView fixGridView = (FixGridView) mActivity.getLayoutInflater().inflate(R.layout.dialog_create_work_page_layout, null);
            fixGridView.setAdapter(new GridViewAdapter(mPageDataList.get(i), mActivity));
            fixGridView.setOnItemClickListener(this);
            listViews.add(fixGridView);
        }

        for (int i = 0; i < mPageDataList.size(); i++) {
            CircleView circleView = new CircleView(mActivity);
            if (i == 0) {
                circleView.setDrawColor(0xff996633);
            } else {
                circleView.setDrawColor(0xffAAAAAA);
            }
            circleView.setRoundWidth(PixelUtils.dp2px(8));
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
            circleView.setLayoutParams(lp);
            if (i != 0) {
                lp.leftMargin = PixelUtils.dp2px(8);
            }
            mContainerIndicator.addView(circleView);
        }

        mFixViewPager.setAdapter(new MyViewPagerAdapter(listViews));
        mDialog.show();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        WorkMain.WorkCategoryItem workCategoryItem = mPageDataList.get(mFixViewPager.getCurrentItem()).get(position);
        if (workCategoryItem.getType().equals(OutdoorSignInFragment.TAB_TYPE)) {
            OutdoorSignCreateFragment.launch(mActivity);
        } else if (workCategoryItem.getType().equals(WorkReportListFragment.TAB_TYPE)) {
            showWorkReportDialog();
        } else if (workCategoryItem.getType().equals(AnnouncementFragment.TAB_TYPE)) {
            AnnouncementCreateFragment.launch(mActivity);
        } else if (workCategoryItem.getType().equals(ShareFragment.TAB_TYPE)) {
            NoticeCreateFragment.launch(mActivity);
        } else if (workCategoryItem.getType().equals(ReportFormListFragment.TAB_TYPE)) {

        } else if (workCategoryItem.getType().equals(ContractApplicationFragment.TAB_TYPE)) {
            ContractApplicationCreateBusinessFragment.launch(mActivity);
        } else if (workCategoryItem.getType().equals(TenderApplicationFragment.TAB_TYPE)) {
            TenderApplicationCreateFragment.launch(mActivity);
        } else if (workCategoryItem.getType().equals(InspectionReceptionApplicationFragment.TAB_TYPE)) {
            InspectionReceptionApplicationCreateFragment.launch(mActivity);
        } else if (workCategoryItem.getType().equals(EntertainmentApplicationFragment.TAB_TYPE)) {
            EntertainmentApplicationCreateFragment.launch(mActivity);
        } else if (workCategoryItem.getType().equals(MarketActivityApplicationFragment.TAB_TYPE)) {
            MarketActivityCreateFragment.launch(mActivity);
        } else if (workCategoryItem.getType().equals(TravelExpenseReimbursementFragment.TAB_TYPE)) {
            TravelExpenseReimbursementCreateFragment.launch(mActivity);
        } else if (workCategoryItem.getType().equals(SpecialDuesReimbursementFragment.TAB_TYPE)) {
            SpecialDuesReimbursementCreateFragment.launch(mActivity);
        } else if (workCategoryItem.getType().equals(EntertainmentReimbursementFragment.TAB_TYPE)) {
            EntertainmentReimbursementCreateFragment.launch(mActivity);
        } else if (workCategoryItem.getType().equals(MarketActivityReimbursementFragment.TAB_TYPE)) {
            MarketActivityReimburseCreateFragment.launch(mActivity);
        }
        mDialog.dismiss();
    }

    private void showWorkReportDialog(){
        ActionSheetDialog actionSheetDialog = new ActionSheetDialog(mActivity);
        actionSheetDialog.builder();
        actionSheetDialog.addSheetItem("写日报", ActionSheetDialog.SheetItemColor.Blue, new ActionSheetDialog.OnSheetItemClickListener() {
            @Override
            public void onClick(int which) {
                WorkReportCreateDaily.launch(mActivity);
            }
        });
        actionSheetDialog.addSheetItem("写周报", ActionSheetDialog.SheetItemColor.Blue, new ActionSheetDialog.OnSheetItemClickListener() {
            @Override
            public void onClick(int which) {
                WorkReportCreateWeekly.launch(mActivity);
            }
        });
        actionSheetDialog.addSheetItem("今日休息", ActionSheetDialog.SheetItemColor.Blue, new ActionSheetDialog.OnSheetItemClickListener() {
            @Override
            public void onClick(int which) {
                todayRestRequest();
            }
        });
        actionSheetDialog.show();
    }

    private void todayRestRequest(){
        HttpRequestParams requestParams = Tools.createHttpRequestParams();
        HashMap<String,String> volleyRequestParams=null;
        if(requestParams!=null){
            volleyRequestParams=requestParams.parseToVolleyRequestParams();
        }
        Request request= HttpRequestUtils.startVolleyRequest(null, ApiUrls.WORKREPORT_SENDCURDAYREST, volleyRequestParams,  new HttpRequestHandler() {
            @Override
            public void onRequestFinished(ResultCode resultCode, String result) {
                switch (resultCode) {
                    case success:
                        BaseResponseBean responseBean = Tools.parseJsonTostError(result, BaseResponseBean.class);
                        if (responseBean != null) {
                            ToastUtils.toast("提交成功！");
                        }
                        break;
                    default:
                        ToastUtils.toast(result);
                        break;
                }
            }
        }, HttpRequestUtils.RequestType.POST);
    }

    private class MyViewPagerAdapter extends PagerAdapter {
        private List<View> mListViews;

        public MyViewPagerAdapter(List<View> mListViews) {
            this.mListViews = mListViews;//构造方法，参数是我们的页卡，这样比较方便。
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(mListViews.get(position));//删除页卡
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {  //这个方法用来实例化页卡
            container.addView(mListViews.get(position), 0);//添加页卡
            return mListViews.get(position);
        }

        @Override
        public int getCount() {
            return mListViews.size();//返回页卡的数量
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;//官方提示这样写
        }
    }

    private class GridViewAdapter extends ABaseAdapter<WorkMain.WorkCategoryItem> {

        public GridViewAdapter(ArrayList<WorkMain.WorkCategoryItem> datas, Activity context) {
            super(datas, context);
        }

        @Override
        protected AbstractItemView<WorkMain.WorkCategoryItem> newItemView() {
            return new GridViewItem();
        }
    }

    private class GridViewItem extends ABaseAdapter.AbstractItemView<WorkMain.WorkCategoryItem> {
        @ViewInject(id = R.id.category_item)
        TextView mViewCategoryItem;

        @Override
        public int inflateViewId() {
            return R.layout.dialog_create_work_page_layout_item;
        }

        @Override
        public void bindingData(View convertView, WorkMain.WorkCategoryItem data) {
            mViewCategoryItem.setText(data.getTitle());
            mViewCategoryItem.setCompoundDrawablesWithIntrinsicBounds(0, data.getCategoryDrawableRes(), 0, 0);
        }
    }

    void OnClick(View v) {
        switch (v.getId()) {
            case R.id.close_btn:
                if (mDialog != null && mDialog.isShowing()) {
                    mDialog.dismiss();
                }
                break;
        }
    }

}

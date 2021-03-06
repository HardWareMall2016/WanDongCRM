package com.android.wandong.ui.fragment.work;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.wandong.R;
import com.android.wandong.beans.OutDoorSignInListResponseBean;
import com.android.wandong.network.ApiUrls;
import com.android.wandong.ui.fragment.common.PhotosFragment;
import com.android.wandong.ui.widget.FixListView;
import com.android.wandong.utils.Tools;
import com.zhan.framework.component.container.FragmentArgs;
import com.zhan.framework.component.container.FragmentContainerActivity;
import com.zhan.framework.network.HttpRequestParams;
import com.zhan.framework.network.HttpRequestUtils;
import com.zhan.framework.support.adapter.ABaseAdapter;
import com.zhan.framework.support.inject.ViewInject;
import com.zhan.framework.ui.activity.BaseActivity;
import com.zhan.framework.ui.fragment.ABaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：伍岳 on 2016/7/22 23:29
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
public class NoticeDetailsFragment extends ABaseFragment implements View.OnClickListener {

    private final static String ARG_KEY = "arg_key";

    //Views
    @ViewInject(id = R.id.viewpager)
    protected ViewPager mImageViewPager;

    @ViewInject(id = R.id.comments_list)
    protected FixListView mListViewComments;

    @ViewInject(id = R.id.indicator)
    protected TextView mViewIndicator;

    @ViewInject(id = R.id.click_to_input, click = "OnClick")
    protected TextView mViewClickToinput;

    //Data
    private String mNoticeId;
    private List<View> mImagePageViews = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    private String mCommentsContent;

    public static void launch(Activity activity, String id) {
        FragmentArgs args = new FragmentArgs();
        args.add(ARG_KEY, id);
        FragmentContainerActivity.launch(activity, NoticeDetailsFragment.class, args);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mNoticeId = savedInstanceState == null ? (String) getArguments().getSerializable(ARG_KEY) : (String) savedInstanceState.getSerializable(ARG_KEY);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(ARG_KEY, mNoticeId);
    }

    @Override
    public void onPrepareSetContentView(BaseActivity activity) {
        super.onPrepareSetContentView(activity);
        activity.setOverlay(true);
        activity.showActionbar(false);
    }

    @Override
    protected int inflateContentView() {
        return R.layout.frag_notice_details;
    }

    @Override
    protected void layoutInit(LayoutInflater inflater, Bundle savedInstanceSate) {
        super.layoutInit(inflater, savedInstanceSate);
        mImageViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mViewIndicator.setText(String.format("%d/%d", position + 1, mImagePageViews.size()));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void requestData() {
        HttpRequestParams requestParams = Tools.createHttpRequestParams();
        requestParams.put("PageIndex", 1);
        requestParams.put("PageNumber", 10);

        startFormRequest(ApiUrls.OUTDOOR_SIGN_IN_LIST, requestParams, new BaseHttpRequestTask<OutDoorSignInListResponseBean>() {
            @Override
            public OutDoorSignInListResponseBean parseResponseToResult(String content) {
                return Tools.parseJson(content, OutDoorSignInListResponseBean.class);
            }

            @Override
            public String verifyResponseResult(OutDoorSignInListResponseBean result) {
                return Tools.verifyResponseResult(result);
            }

            @Override
            protected void onSuccess(OutDoorSignInListResponseBean result) {
                super.onSuccess(result);
                //这里加正确处理的逻辑就好了

                for (int i = 0; i < 4; i++) {
                    ImageView img = new ImageView(getActivity());
                    img.setScaleType(ImageView.ScaleType.FIT_XY);
                    img.setImageResource(R.drawable.def_pic);
                    img.setOnClickListener(NoticeDetailsFragment.this);
                    mImagePageViews.add(img);

                    mImageUrls.add("");
                }
                mImageViewPager.setAdapter(new ImagePageAdapter());

                //只需要显示3行评论
                ArrayList<Comments> dataList = new ArrayList<>();
                dataList.add(new Comments());
                dataList.add(new Comments());
                dataList.add(new Comments());

                mListViewComments.setAdapter(new CommentsAdapter(dataList, getActivity()));

            }
        }, HttpRequestUtils.RequestType.POST);
    }

    @Override
    public void onClick(View v) {
        PhotosFragment.launch(getActivity(), mImageUrls, mImageViewPager.getCurrentItem());
    }

    void OnClick(View v) {
        switch (v.getId()) {
            case R.id.click_to_input:
                Dialog dialog= Tools.showDialogFromBottom(getActivity(),R.layout.dialog_notice_comments_input,true);
                final EditText commentsContent = (EditText) dialog.findViewById(R.id.comments_content);
                if(!TextUtils.isEmpty(mCommentsContent)){
                    commentsContent.setText(mCommentsContent);
                }
                commentsContent.requestFocus();
                dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        mCommentsContent = commentsContent.getText().toString();
                        if (!TextUtils.isEmpty(mCommentsContent)) {
                            mViewClickToinput.setText(mCommentsContent);
                        } else {
                            mViewClickToinput.setText("点击输入评论内容");
                        }
                    }
                });
                break;
        }
    }

    private class ImagePageAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return mImagePageViews.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(mImagePageViews.get(position));
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(mImagePageViews.get(position));
            return mImagePageViews.get(position);
        }
    }

    private class Comments {

    }

    private class CommentsAdapter extends ABaseAdapter<Comments> {

        public CommentsAdapter(ArrayList<Comments> datas, Activity context) {
            super(datas, context);
        }

        @Override
        protected AbstractItemView<Comments> newItemView() {
            return new CommentsItemView();
        }
    }

    private class CommentsItemView extends ABaseAdapter.AbstractItemView<Comments> {

        @Override
        public int inflateViewId() {
            return R.layout.list_item_notice_details_comments;
        }

        @Override
        public void bindingData(View convertView, Comments data) {

        }
    }

}

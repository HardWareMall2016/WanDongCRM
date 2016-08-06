package com.android.wandong.ui.fragment.work;

import android.view.View;
import android.widget.ImageView;

import com.android.wandong.R;
import com.android.wandong.base.UserInfo;
import com.android.wandong.beans.CompaignListResponseBean;
import com.android.wandong.beans.NoticeResponseBean;
import com.android.wandong.network.ApiUrls;
import com.zhan.framework.network.HttpRequestParams;
import com.zhan.framework.support.adapter.ABaseAdapter;
import com.zhan.framework.support.inject.ViewInject;

import java.util.List;

/**
 * 作者：伍岳 on 2016/7/29 16:20
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
public class MarketActivityApplicationFragment extends BaseWorkPageFragment<MarketActivityApplicationFragment.ItemData, NoticeResponseBean> {
    public static final String TAB_TYPE="MARKET_ACTIVITY_APPLICATION";
    public static final String TAB_NAME="市场活动费申请";

    @Override
    protected void populateRequestParams(RefreshMode mode, HttpRequestParams requestParams) {
        requestParams.put("UserName", UserInfo.getCurrentUser().getUserName());
        requestParams.put("PassWord",UserInfo.getCurrentUser().getPassword());
        requestParams.put("PageIndex",getNextPage(mode));
        requestParams.put("PageNumber", getRefreshConfig().minResultSize);
        requestParams.put("UserId", UserInfo.getCurrentUser().getUserId());

    }

    @Override
    protected String getRequestApiUrl() {
        return ApiUrls.COMPAIGN_APPLY_LIST;
    }

    @Override
    protected void parseResponseBeanToItemDataList(NoticeResponseBean baseResponseBean, List<ItemData> items) {
        //if(baseResponseBean.getEntityInfo()!=null){
            for(int i=0;i<10;i++){
                ItemData item=new ItemData();
                items.add(item);
            }
       // }
    }


    @Override
    protected ABaseAdapter.AbstractItemView<ItemData> newItemView() {
        return new ListItemView();
    }

    private class ListItemView extends ABaseAdapter.AbstractItemView<ItemData>{

        @ViewInject(id = R.id.headPortrait)
        protected ImageView mViewHeadPortrait;

        @Override
        public int inflateViewId() {
            return R.layout.list_item_market_activity_application;
        }

        @Override
        public void bindingData(View convertView, ItemData data) {

        }
    }

    public class ItemData {

    }
}

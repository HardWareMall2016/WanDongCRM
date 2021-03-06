package com.android.wandong.ui.fragment.work;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.wandong.R;
import com.android.wandong.beans.MarketActivityReimbursementResponseBean;
import com.android.wandong.beans.NoticeResponseBean;
import com.android.wandong.network.ApiUrls;
import com.android.wandong.ui.fragment.work.Tools.AuditStatusHelper;
import com.android.wandong.ui.fragment.work.Tools.MarketActivityApplicationDetailsFragment;
import com.android.wandong.utils.Tools;
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
public class MarketActivityReimbursementFragment extends BaseWorkPageFragment<MarketActivityReimbursementFragment.ItemData, MarketActivityReimbursementResponseBean> {
    public static final String TAB_TYPE="MARKET_ACTIVITY_REIMBURSEMENT";
    public static final String TAB_NAME="市场活动费报销";

    @Override
    protected void populateRequestParams(RefreshMode mode, HttpRequestParams requestParams) {
        requestParams.put("PageIndex",getNextPage(mode));
        requestParams.put("PageNumber", getRefreshConfig().minResultSize);
        requestParams.put("IsJustLookOwner", "");
        requestParams.put("EndDate","");
        requestParams.put("CostType","");
        requestParams.put("BeginDate","");
        requestParams.put("AuditStatus","");

    }

    @Override
    protected String getRequestApiUrl() {
        return ApiUrls.CAMPAIGN_EXPENSE_LIST;
    }

    @Override
    protected void parseResponseBeanToItemDataList(MarketActivityReimbursementResponseBean baseResponseBean, List<ItemData> items) {
        if(baseResponseBean.getEntityInfo()!=null){
            for(MarketActivityReimbursementResponseBean.EntityInfoBean beanItem:baseResponseBean.getEntityInfo()){
                ItemData item=new ItemData();
                item.setCampaignId(beanItem.getCampaignId());
                item.setApplyNo(beanItem.getApplyNo());
                item.setStatus(beanItem.getStatus());
                item.setName(beanItem.getName());
                item.setCostType(beanItem.getCostType());
                item.setCostTypeName(beanItem.getCostTypeName());
                item.setOccurTime(beanItem.getOccurTime());
                item.setAmount(beanItem.getAmount());
                item.setOwnerName(beanItem.getOwnerName());
                item.setCreatedOn(beanItem.getCreatedOn());
                items.add(item);
            }
        }
    }

    @Override
    protected ABaseAdapter.AbstractItemView<ItemData> newItemView() {
        return new ListItemView();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        MarketActivityReimbursementDetailsFragment.launch(getActivity(), getAdapterItems().get((int) id).CampaignId);
    }

    private class ListItemView extends ABaseAdapter.AbstractItemView<ItemData>{

        @ViewInject(id = R.id.ApplyNo)
        TextView mApplyNo ;
        @ViewInject(id = R.id.AccountName)
        TextView mAccountName ;
        @ViewInject(id = R.id.name)
        TextView mName ;
        @ViewInject(id = R.id.number)
        TextView mNumber ;
        @ViewInject(id = R.id.headPortrait)
        ImageView mViewHeadPortrait;
        @ViewInject(id = R.id.img_status)
        ImageView mViewStatus ;
        @ViewInject(id = R.id.time)
        TextView mViewTime;

        @Override
        public int inflateViewId() {
            return R.layout.list_item_market_activity_reimbursement;
        }

        @Override
        public void bindingData(View convertView, ItemData data) {
            mApplyNo.setText(data.getApplyNo());
            mAccountName.setText(data.getName()+"("+data.getCostTypeName()+")");
            mName.setText(data.getOwnerName());
            mNumber.setText(data.getAmount()+"元");
            Tools.setTextView(mViewTime, Tools.parseTimeToDateStr(Tools.parseDateStrToLong(data.getCreatedOn())));
            AuditStatusHelper.setImageViewByStatus(mViewStatus, data.getStatus());
        }
    }

    public class ItemData {
        private String CampaignId;
        private String ApplyNo;
        private int Status;
        private String Name;
        private int CostType;
        private String CostTypeName;
        private String OccurTime;
        private double Amount;
        private String OwnerName;
        private String CreatedOn;

        public String getCampaignId() {
            return CampaignId;
        }

        public void setCampaignId(String CampaignId) {
            this.CampaignId = CampaignId;
        }

        public String getApplyNo() {
            return ApplyNo;
        }

        public void setApplyNo(String ApplyNo) {
            this.ApplyNo = ApplyNo;
        }

        public int getStatus() {
            return Status;
        }

        public void setStatus(int Status) {
            this.Status = Status;
        }

        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public int getCostType() {
            return CostType;
        }

        public void setCostType(int CostType) {
            this.CostType = CostType;
        }

        public String getCostTypeName() {
            return CostTypeName;
        }

        public void setCostTypeName(String CostTypeName) {
            this.CostTypeName = CostTypeName;
        }

        public String getOccurTime() {
            return OccurTime;
        }

        public void setOccurTime(String OccurTime) {
            this.OccurTime = OccurTime;
        }

        public double getAmount() {
            return Amount;
        }

        public void setAmount(double Amount) {
            this.Amount = Amount;
        }

        public String getOwnerName() {
            return OwnerName;
        }

        public void setOwnerName(String OwnerName) {
            this.OwnerName = OwnerName;
        }

        public String getCreatedOn() {
            return CreatedOn;
        }

        public void setCreatedOn(String CreatedOn) {
            this.CreatedOn = CreatedOn;
        }
    }
}

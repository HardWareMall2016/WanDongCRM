package com.android.wandong.ui.fragment.work;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.wandong.R;
import com.android.wandong.base.UserInfo;
import com.android.wandong.beans.ContractProductLineListResponseBean;
import com.android.wandong.beans.ContractProductModelListResponseBean;
import com.android.wandong.network.ApiUrls;
import com.android.wandong.utils.Tools;
import com.zhan.framework.component.container.FragmentContainerActivity;
import com.zhan.framework.network.HttpRequestParams;
import com.zhan.framework.network.HttpRequestUtils;
import com.zhan.framework.support.adapter.ABaseAdapter;
import com.zhan.framework.support.inject.ViewInject;
import com.zhan.framework.ui.fragment.APullToRefreshListFragment;
import com.zhan.framework.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ${keke} on 16/8/17.
 */
public class ContractApplicationProductModelListFragment extends APullToRefreshListFragment<ContractApplicationProductModelListFragment.AccountInfo> {

    public static String KEY_ACCOUNT_NAME="account_name";
    public static String KEY_ACCOUNT_ID="account_id";

    private int mSelectedPos=-1;


    public static void launchForResult(ContractApplicationCreateFragment from, int requestCode) {
        FragmentContainerActivity.launchForResult(from, ContractApplicationProductModelListFragment.class, null, requestCode);
    }

    @Override
    public void onPrepareActionbarMenu(TextView menu, Activity activity) {
        menu.setText("确定");
    }

    @Override
    public void onActionBarMenuClick() {
        if(mSelectedPos==-1){
            ToastUtils.toast("请选择投标产品");
            return;
        }

        AccountInfo accountInfo = getAdapterItems().get(mSelectedPos);

        Intent intent=new Intent();
        intent.putExtra(KEY_ACCOUNT_NAME,accountInfo.Name);
        intent.putExtra(KEY_ACCOUNT_ID, accountInfo.Id);
        getActivity().setResult(Activity.RESULT_OK, intent);
        getActivity().finish();
    }

    @Override
    protected void layoutInit(LayoutInflater inflater, Bundle savedInstanceSate) {
        super.layoutInit(inflater, savedInstanceSate);
        getActivity().setTitle("投标产品");
        mSelectedPos=-1;
    }

    @Override
    protected void configRefresh(RefreshConfig config) {
        config.minResultSize=20;
    }

    @Override
    protected ABaseAdapter.AbstractItemView<ContractApplicationProductModelListFragment.AccountInfo> newItemView() {
        return new ItemView();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if(mSelectedPos!=id){
            mSelectedPos= (int) id;
            notifyDataSetChanged();
        }
    }

    private class ItemView extends ABaseAdapter.AbstractItemView<AccountInfo>{
        @ViewInject(id = R.id.AccountName)
        TextView mViewAccountName ;

        @ViewInject(id = R.id.imgStatus)
        ImageView mViewStatus ;

        @Override
        public int inflateViewId() {
            return R.layout.list_item_account;
        }

        @Override
        public void bindingData(View convertView, AccountInfo data) {
            Tools.setTextView(mViewAccountName, data.Name);
            if(mSelectedPos==getPosition()){
                mViewStatus.setImageResource(R.drawable.checkbox_sel);
            }else{
                mViewStatus.setImageResource(R.drawable.checkbox_unsel);
            }
        }
    }


    @Override
    protected void requestData(RefreshMode mode) {
        if(mode!=RefreshMode.update){
            mSelectedPos=-1;
        }

        HttpRequestParams requestParams = new HttpRequestParams();
        requestParams.put("UserName", UserInfo.getCurrentUser().getUserName());
        requestParams.put("PassWord", UserInfo.getCurrentUser().getPassword());
        requestParams.put("PageIndex",getNextPage(mode));
        requestParams.put("PageNumber", getRefreshConfig().minResultSize);
        requestParams.put("ProductClassifyId","089c9037-b918-e611-ac23-085700e64e0f");

        startFormRequest(ApiUrls.OPPORTUNITY_GETPRODUCT, requestParams, new PagingTask<ContractProductModelListResponseBean>(mode) {
            @Override
            public ContractProductModelListResponseBean parseResponseToResult(String content) {
                return Tools.parseJson(content, ContractProductModelListResponseBean.class);
            }

            @Override
            public String verifyResponseResult(ContractProductModelListResponseBean result) {
                return Tools.verifyResponseResult(result);
            }

            @Override
            protected List<AccountInfo> parseResult(ContractProductModelListResponseBean baseResponseBean) {
                List<AccountInfo> items = new ArrayList<>();
                if (baseResponseBean != null && baseResponseBean.getEntityInfo() != null) {
                    for (ContractProductModelListResponseBean.EntityInfoBean bean : baseResponseBean.getEntityInfo()) {
                        AccountInfo reportDataItem = new AccountInfo();
                        reportDataItem.Id = bean.getId();
                        reportDataItem.Name = bean.getName();
                        reportDataItem.Price = bean.getPrice();
                        items.add(reportDataItem);
                    }
                }
                return items;
            }
        }, HttpRequestUtils.RequestType.POST);
    }

    public class AccountInfo{
        String Id;
        String Name;
        int Price;
    }
}

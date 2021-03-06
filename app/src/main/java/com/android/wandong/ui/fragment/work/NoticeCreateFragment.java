package com.android.wandong.ui.fragment.work;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.wandong.R;
import com.zhan.framework.component.container.FragmentContainerActivity;
import com.zhan.framework.support.inject.ViewInject;
import com.zhan.framework.ui.fragment.ABaseFragment;
import com.zhan.framework.ui.widget.ActionSheetDialog;

/**
 * Created by ${keke} on 16/8/14.
 */
public class NoticeCreateFragment extends ABaseFragment{
    private final static int REQUEST_CODE=100;

    @ViewInject(id = R.id.imgAddPhoto,click = "OnClick")
    ImageView mAddPhoto ;
    @ViewInject(id = R.id.announcement_object,click = "OnClick")
    RelativeLayout mAnnouncementObject;
    @ViewInject(id = R.id.announcement_object_number)
    TextView mObjectNumber;


    public static void launch(Activity mActivity) {
        FragmentContainerActivity.launch(mActivity, NoticeCreateFragment.class, null);
    }

    @Override
    protected int inflateContentView() {
        return R.layout.frag_notice_create;
    }

    @Override
    protected void layoutInit(LayoutInflater inflater, Bundle savedInstanceSate) {
        super.layoutInit(inflater, savedInstanceSate);
        getActivity().setTitle("发布通知");
    }

    void OnClick(View v) {
        switch (v.getId()){
            case R.id.imgAddPhoto:
                ActionSheetDialog actionSheetDialog=new ActionSheetDialog(getActivity());
                actionSheetDialog.builder();
                actionSheetDialog.addSheetItem("拍照", ActionSheetDialog.SheetItemColor.Blue, new ActionSheetDialog.OnSheetItemClickListener(){
                    @Override
                    public void onClick(int which) {

                    }
                });
                actionSheetDialog.addSheetItem("相册", ActionSheetDialog.SheetItemColor.Blue, new ActionSheetDialog.OnSheetItemClickListener(){
                    @Override
                    public void onClick(int which) {

                    }
                });

                actionSheetDialog.show();
                break;
            case R.id.announcement_object:
                //NoticeCreateObjectFragment.launch(NoticeCreateFragment.this,REQUEST_CODE);
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==REQUEST_CODE&&resultCode== Activity.RESULT_OK){
            mObjectNumber.setText("123");
        }
    }
}

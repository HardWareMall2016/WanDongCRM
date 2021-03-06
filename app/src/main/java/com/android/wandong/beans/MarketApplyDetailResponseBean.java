package com.android.wandong.beans;

import com.android.wandong.base.BaseResponseBean;

import java.util.List;

/**
 * Created by ${keke} on 16/8/7.
 */
public class MarketApplyDetailResponseBean extends BaseResponseBean {
    /**
     * errorcode : 200
     * entityInfo : {"Detail":{"CampaignId":"ad465fe2-e15a-e611-92fc-085700e64e0f","Name":"SCSQ201608000016","CampaignName":"100","CostType":2,"OccurTime":"/Date(1470844800000)/","Amount":200,"Remark":"备注信息备注信息","Quantity":0,"AuditStatus":3,"OwnerId":"c52610c5-60fd-e511-a1e5-085700e64e0f","OwnerName":"姓名","CreatedOn":"/Date(1470383690000)/","StepNumber":2},"Approval":[{"StepNumber":"1","ApprovalTime":"2016-08-05 16:32","ApprovalPrice":200,"Opinion":"审批测试","Result":"通过","ApproverId":"c52610c5-60fd-e511-a1e5-085700e64e0f","Approver":"姓名"},{"StepNumber":"2","ApprovalTime":"2016-08-05 16:32","ApprovalPrice":200,"Opinion":"审批测试","Result":"通过","ApproverId":"c52610c5-60fd-e511-a1e5-085700e64e0f","Approver":"姓名"}],"isApprover":false}
     */

    private int errorcode;
    /**
     * Detail : {"CampaignId":"ad465fe2-e15a-e611-92fc-085700e64e0f","Name":"SCSQ201608000016","CampaignName":"100","CostType":2,"OccurTime":"/Date(1470844800000)/","Amount":200,"Remark":"备注信息备注信息","Quantity":0,"AuditStatus":3,"OwnerId":"c52610c5-60fd-e511-a1e5-085700e64e0f","OwnerName":"姓名","CreatedOn":"/Date(1470383690000)/","StepNumber":2}
     * Approval : [{"StepNumber":"1","ApprovalTime":"2016-08-05 16:32","ApprovalPrice":200,"Opinion":"审批测试","Result":"通过","ApproverId":"c52610c5-60fd-e511-a1e5-085700e64e0f","Approver":"姓名"},{"StepNumber":"2","ApprovalTime":"2016-08-05 16:32","ApprovalPrice":200,"Opinion":"审批测试","Result":"通过","ApproverId":"c52610c5-60fd-e511-a1e5-085700e64e0f","Approver":"姓名"}]
     * isApprover : false
     */

    private EntityInfoBean entityInfo;

    public int getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(int errorcode) {
        this.errorcode = errorcode;
    }

    public EntityInfoBean getEntityInfo() {
        return entityInfo;
    }

    public void setEntityInfo(EntityInfoBean entityInfo) {
        this.entityInfo = entityInfo;
    }

    public static class EntityInfoBean {
        /**
         * CampaignId : ad465fe2-e15a-e611-92fc-085700e64e0f
         * Name : SCSQ201608000016
         * CampaignName : 100
         * CostType : 2
         * OccurTime : /Date(1470844800000)/
         * Amount : 200.0
         * Remark : 备注信息备注信息
         * Quantity : 0
         * AuditStatus : 3
         * OwnerId : c52610c5-60fd-e511-a1e5-085700e64e0f
         * OwnerName : 姓名
         * CreatedOn : /Date(1470383690000)/
         * StepNumber : 2
         */

        private DetailBean Detail;
        private boolean isApprover;
        /**
         * StepNumber : 1
         * ApprovalTime : 2016-08-05 16:32
         * ApprovalPrice : 200.0
         * Opinion : 审批测试
         * Result : 通过
         * ApproverId : c52610c5-60fd-e511-a1e5-085700e64e0f
         * Approver : 姓名
         */

        private List<ApprovalBean> Approval;

        public DetailBean getDetail() {
            return Detail;
        }

        public void setDetail(DetailBean Detail) {
            this.Detail = Detail;
        }

        public boolean isIsApprover() {
            return isApprover;
        }

        public void setIsApprover(boolean isApprover) {
            this.isApprover = isApprover;
        }

        public List<ApprovalBean> getApproval() {
            return Approval;
        }

        public void setApproval(List<ApprovalBean> Approval) {
            this.Approval = Approval;
        }

        public static class DetailBean {
            private String CampaignId;
            private String Name;
            private String CampaignName;
            private int CostType;
            private String OccurTime;
            private double Amount;
            private String Remark;
            private int Quantity;
            private int AuditStatus;
            private String OwnerId;
            private String OwnerName;
            private String CreatedOn;
            private int StepNumber;

            public String getCampaignId() {
                return CampaignId;
            }

            public void setCampaignId(String CampaignId) {
                this.CampaignId = CampaignId;
            }

            public String getName() {
                return Name;
            }

            public void setName(String Name) {
                this.Name = Name;
            }

            public String getCampaignName() {
                return CampaignName;
            }

            public void setCampaignName(String CampaignName) {
                this.CampaignName = CampaignName;
            }

            public int getCostType() {
                return CostType;
            }

            public void setCostType(int CostType) {
                this.CostType = CostType;
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

            public String getRemark() {
                return Remark;
            }

            public void setRemark(String Remark) {
                this.Remark = Remark;
            }

            public int getQuantity() {
                return Quantity;
            }

            public void setQuantity(int Quantity) {
                this.Quantity = Quantity;
            }

            public int getAuditStatus() {
                return AuditStatus;
            }

            public void setAuditStatus(int AuditStatus) {
                this.AuditStatus = AuditStatus;
            }

            public String getOwnerId() {
                return OwnerId;
            }

            public void setOwnerId(String OwnerId) {
                this.OwnerId = OwnerId;
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

            public int getStepNumber() {
                return StepNumber;
            }

            public void setStepNumber(int StepNumber) {
                this.StepNumber = StepNumber;
            }
        }

        public static class ApprovalBean {
            private String StepNumber;
            private String ApprovalTime;
            private double ApprovalPrice;
            private String Opinion;
            private String Result;
            private String ApproverId;
            private String Approver;

            public String getStepNumber() {
                return StepNumber;
            }

            public void setStepNumber(String StepNumber) {
                this.StepNumber = StepNumber;
            }

            public String getApprovalTime() {
                return ApprovalTime;
            }

            public void setApprovalTime(String ApprovalTime) {
                this.ApprovalTime = ApprovalTime;
            }

            public double getApprovalPrice() {
                return ApprovalPrice;
            }

            public void setApprovalPrice(double ApprovalPrice) {
                this.ApprovalPrice = ApprovalPrice;
            }

            public String getOpinion() {
                return Opinion;
            }

            public void setOpinion(String Opinion) {
                this.Opinion = Opinion;
            }

            public String getResult() {
                return Result;
            }

            public void setResult(String Result) {
                this.Result = Result;
            }

            public String getApproverId() {
                return ApproverId;
            }

            public void setApproverId(String ApproverId) {
                this.ApproverId = ApproverId;
            }

            public String getApprover() {
                return Approver;
            }

            public void setApprover(String Approver) {
                this.Approver = Approver;
            }
        }
    }
}

package com.android.wandong.beans;

import com.android.wandong.base.BaseResponseBean;

import java.util.List;

/**
 * Created by ${keke} on 16/8/7.
 */
public class TravelExpenseReimburseDetailsResponseBean extends BaseResponseBean {
    /**
     * errorcode : 200
     * entityInfo : {"Detail":[{"TravelPaymentId":"f8a1548e-d669-e611-92fc-085700e64e0f","BeginDate":"/Date(1471998600000)/","EndDate":"/Date(1472178600000)/","TravelDays":"","HotelDays":"","Origin":"测试你的","Destination":"测试","Transport":2,"TransportName":"火车","IsGoBack":false,"TrainTicket":null,"Allowance":null,"OilFuel":null,"LocalTravel":"0.00","CrossTravel":null,"Hotel":"0.00","Travel":22,"HotelSubsidy":0,"MealSubsidy":0,"CarSubsidy":0,"Other":0,"IsDiscount":false,"DiscountRate":"二等座","Remark":"测试","OwnerId":"c52610c5-60fd-e511-a1e5-085700e64e0f","OwnerName":"姓名","CreatedOn":"/Date(1472028092000)/","PersonalImage":"UploadedFiles/HeadPortrait/cc7e4862-1204-45a3-80a6-68ee24193775.jpeg"}],"Approval":[{"StepNumber":"1","ApprovalTime":"2016-08-25 11:50","ApprovalPrice":22,"Opinion":"同意了","Result":"通过","ApproverId":"027503d7-9b54-e611-be6c-085700e64e0f","Approver":"单元经理"}],"isApprover":false}
     */

    private int errorcode;
    /**
     * Detail : [{"TravelPaymentId":"f8a1548e-d669-e611-92fc-085700e64e0f","BeginDate":"/Date(1471998600000)/","EndDate":"/Date(1472178600000)/","TravelDays":"","HotelDays":"","Origin":"测试你的","Destination":"测试","Transport":2,"TransportName":"火车","IsGoBack":false,"TrainTicket":null,"Allowance":null,"OilFuel":null,"LocalTravel":"0.00","CrossTravel":null,"Hotel":"0.00","Travel":22,"HotelSubsidy":0,"MealSubsidy":0,"CarSubsidy":0,"Other":0,"IsDiscount":false,"DiscountRate":"二等座","Remark":"测试","OwnerId":"c52610c5-60fd-e511-a1e5-085700e64e0f","OwnerName":"姓名","CreatedOn":"/Date(1472028092000)/","PersonalImage":"UploadedFiles/HeadPortrait/cc7e4862-1204-45a3-80a6-68ee24193775.jpeg"}]
     * Approval : [{"StepNumber":"1","ApprovalTime":"2016-08-25 11:50","ApprovalPrice":22,"Opinion":"同意了","Result":"通过","ApproverId":"027503d7-9b54-e611-be6c-085700e64e0f","Approver":"单元经理"}]
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
        private boolean isApprover;
        /**
         * TravelPaymentId : f8a1548e-d669-e611-92fc-085700e64e0f
         * BeginDate : /Date(1471998600000)/
         * EndDate : /Date(1472178600000)/
         * TravelDays :
         * HotelDays :
         * Origin : 测试你的
         * Destination : 测试
         * Transport : 2
         * TransportName : 火车
         * IsGoBack : false
         * TrainTicket : null
         * Allowance : null
         * OilFuel : null
         * LocalTravel : 0.00
         * CrossTravel : null
         * Hotel : 0.00
         * Travel : 22.0
         * HotelSubsidy : 0.0
         * MealSubsidy : 0.0
         * CarSubsidy : 0.0
         * Other : 0.0
         * IsDiscount : false
         * DiscountRate : 二等座
         * Remark : 测试
         * OwnerId : c52610c5-60fd-e511-a1e5-085700e64e0f
         * OwnerName : 姓名
         * CreatedOn : /Date(1472028092000)/
         * PersonalImage : UploadedFiles/HeadPortrait/cc7e4862-1204-45a3-80a6-68ee24193775.jpeg
         */

        private List<DetailBean> Detail;
        /**
         * StepNumber : 1
         * ApprovalTime : 2016-08-25 11:50
         * ApprovalPrice : 22.0
         * Opinion : 同意了
         * Result : 通过
         * ApproverId : 027503d7-9b54-e611-be6c-085700e64e0f
         * Approver : 单元经理
         */

        private List<ApprovalBean> Approval;

        public boolean isIsApprover() {
            return isApprover;
        }

        public void setIsApprover(boolean isApprover) {
            this.isApprover = isApprover;
        }

        public List<DetailBean> getDetail() {
            return Detail;
        }

        public void setDetail(List<DetailBean> Detail) {
            this.Detail = Detail;
        }

        public List<ApprovalBean> getApproval() {
            return Approval;
        }

        public void setApproval(List<ApprovalBean> Approval) {
            this.Approval = Approval;
        }

        public static class DetailBean {
            private String TravelPaymentId;
            private String BeginDate;
            private String EndDate;
            private String TravelDays;
            private String HotelDays;
            private String Origin;
            private String Destination;
            private int Transport;
            private String TransportName;
            private boolean IsGoBack;
            private Object TrainTicket;
            private Object Allowance;
            private Object OilFuel;
            private String LocalTravel;
            private Object CrossTravel;
            private String Hotel;
            private double Travel;
            private double HotelSubsidy;
            private double MealSubsidy;
            private double CarSubsidy;
            private double Other;
            private boolean IsDiscount;
            private String DiscountRate;
            private String Remark;
            private String OwnerId;
            private String OwnerName;
            private String CreatedOn;
            private String PersonalImage;

            public String getTravelPaymentId() {
                return TravelPaymentId;
            }

            public void setTravelPaymentId(String TravelPaymentId) {
                this.TravelPaymentId = TravelPaymentId;
            }

            public String getBeginDate() {
                return BeginDate;
            }

            public void setBeginDate(String BeginDate) {
                this.BeginDate = BeginDate;
            }

            public String getEndDate() {
                return EndDate;
            }

            public void setEndDate(String EndDate) {
                this.EndDate = EndDate;
            }

            public String getTravelDays() {
                return TravelDays;
            }

            public void setTravelDays(String TravelDays) {
                this.TravelDays = TravelDays;
            }

            public String getHotelDays() {
                return HotelDays;
            }

            public void setHotelDays(String HotelDays) {
                this.HotelDays = HotelDays;
            }

            public String getOrigin() {
                return Origin;
            }

            public void setOrigin(String Origin) {
                this.Origin = Origin;
            }

            public String getDestination() {
                return Destination;
            }

            public void setDestination(String Destination) {
                this.Destination = Destination;
            }

            public int getTransport() {
                return Transport;
            }

            public void setTransport(int Transport) {
                this.Transport = Transport;
            }

            public String getTransportName() {
                return TransportName;
            }

            public void setTransportName(String TransportName) {
                this.TransportName = TransportName;
            }

            public boolean isIsGoBack() {
                return IsGoBack;
            }

            public void setIsGoBack(boolean IsGoBack) {
                this.IsGoBack = IsGoBack;
            }

            public Object getTrainTicket() {
                return TrainTicket;
            }

            public void setTrainTicket(Object TrainTicket) {
                this.TrainTicket = TrainTicket;
            }

            public Object getAllowance() {
                return Allowance;
            }

            public void setAllowance(Object Allowance) {
                this.Allowance = Allowance;
            }

            public Object getOilFuel() {
                return OilFuel;
            }

            public void setOilFuel(Object OilFuel) {
                this.OilFuel = OilFuel;
            }

            public String getLocalTravel() {
                return LocalTravel;
            }

            public void setLocalTravel(String LocalTravel) {
                this.LocalTravel = LocalTravel;
            }

            public Object getCrossTravel() {
                return CrossTravel;
            }

            public void setCrossTravel(Object CrossTravel) {
                this.CrossTravel = CrossTravel;
            }

            public String getHotel() {
                return Hotel;
            }

            public void setHotel(String Hotel) {
                this.Hotel = Hotel;
            }

            public double getTravel() {
                return Travel;
            }

            public void setTravel(double Travel) {
                this.Travel = Travel;
            }

            public double getHotelSubsidy() {
                return HotelSubsidy;
            }

            public void setHotelSubsidy(double HotelSubsidy) {
                this.HotelSubsidy = HotelSubsidy;
            }

            public double getMealSubsidy() {
                return MealSubsidy;
            }

            public void setMealSubsidy(double MealSubsidy) {
                this.MealSubsidy = MealSubsidy;
            }

            public double getCarSubsidy() {
                return CarSubsidy;
            }

            public void setCarSubsidy(double CarSubsidy) {
                this.CarSubsidy = CarSubsidy;
            }

            public double getOther() {
                return Other;
            }

            public void setOther(double Other) {
                this.Other = Other;
            }

            public boolean isIsDiscount() {
                return IsDiscount;
            }

            public void setIsDiscount(boolean IsDiscount) {
                this.IsDiscount = IsDiscount;
            }

            public String getDiscountRate() {
                return DiscountRate;
            }

            public void setDiscountRate(String DiscountRate) {
                this.DiscountRate = DiscountRate;
            }

            public String getRemark() {
                return Remark;
            }

            public void setRemark(String Remark) {
                this.Remark = Remark;
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

            public String getPersonalImage() {
                return PersonalImage;
            }

            public void setPersonalImage(String PersonalImage) {
                this.PersonalImage = PersonalImage;
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

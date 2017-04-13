package id.ac.ugm.blog.tejo_suharyono.listjson.model.data;

public class ItemDataModel {

    public String message, sender, is_from_me, time;
    private ItemDataModel(Builder builder){
        message        = builder.mMessages;
        sender         = builder.mSenders;
        is_from_me     = builder.mIs_from_mes;
        time           = builder.mTimes;
    }

    public static class Builder {

        private String mMessages, mSenders, mIs_from_mes, mTimes;

        public Builder setMessage(String message) {
            mMessages = message;
            return Builder.this;
        }

        public Builder setSender(String sender) {
            mSenders = sender;
            return Builder.this;
        }

        public Builder setIs_from_me(String is_from_me) {
            mIs_from_mes = is_from_me;
            return Builder.this;
        }

        public Builder setTime(String time) {
            mTimes = time;
            return Builder.this;
        }

        public ItemDataModel build() {
            return new ItemDataModel(Builder.this);
        }
    }
}

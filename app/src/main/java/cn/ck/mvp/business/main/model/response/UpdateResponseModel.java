package cn.ck.mvp.business.main.model.response;

/**
 * Created by ck on 2018/10/5.
 */
public class UpdateResponseModel {
    /**
     * hasNew : true
     * version_content : {"id":1,"version_num":"1.0","version_content":" 初始版本","updated_at":"2018-10-01 12:06:28","apk_url":"http://www.baidu.com","client":"student"}
     */

    private boolean hasNew;
    private VersionContentBean version_content;

    public boolean isHasNew() {
        return hasNew;
    }

    public void setHasNew(boolean hasNew) {
        this.hasNew = hasNew;
    }

    public VersionContentBean getVersion_content() {
        return version_content;
    }

    public void setVersion_content(VersionContentBean version_content) {
        this.version_content = version_content;
    }

    public static class VersionContentBean {
        /**
         * id : 1
         * version_num : 1.0
         * version_content :  初始版本
         * updated_at : 2018-10-01 12:06:28
         * apk_url : http://www.baidu.com
         * client : student
         */

        private int id;
        private String version_num;
        private String version_content;
        private String updated_at;
        private String apk_url;
        private String client;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getVersion_num() {
            return version_num;
        }

        public void setVersion_num(String version_num) {
            this.version_num = version_num;
        }

        public String getVersion_content() {
            return version_content;
        }

        public void setVersion_content(String version_content) {
            this.version_content = version_content;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }

        public String getApk_url() {
            return apk_url;
        }

        public void setApk_url(String apk_url) {
            this.apk_url = apk_url;
        }

        public String getClient() {
            return client;
        }

        public void setClient(String client) {
            this.client = client;
        }
    }
}

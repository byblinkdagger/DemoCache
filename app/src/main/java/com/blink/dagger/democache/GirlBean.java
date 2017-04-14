package com.blink.dagger.democache;

import java.util.List;

/**
 * Created by lucky on 2017/4/14.
 */
public class GirlBean {

    /**
     * error : false
     * results : [{"_id":"57cc16c9421aa910f56bd8ab","createdAt":"2016-09-04T20:42:49.403Z","desc":"09-05","publishedAt":"2016-09-05T11:32:16.999Z","source":"chrome","type":"福利","url":"http://ww1.sinaimg.cn/large/610dc034jw1f7hu7d460oj20u00u075u.jpg","used":true,"who":"daimajia"}]
     */

    private boolean error;
    private List<ResultsBean> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * _id : 57cc16c9421aa910f56bd8ab
         * createdAt : 2016-09-04T20:42:49.403Z
         * desc : 09-05
         * publishedAt : 2016-09-05T11:32:16.999Z
         * source : chrome
         * type : 福利
         * url : http://ww1.sinaimg.cn/large/610dc034jw1f7hu7d460oj20u00u075u.jpg
         * used : true
         * who : daimajia
         */

        private String createdAt;
        private String desc;
        private String type;
        private String url;

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}

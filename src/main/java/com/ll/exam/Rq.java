package com.ll.exam;

public class Rq {
    String url;
    String path;
    String queryStr;

    public Rq(String url) {
        this.url = url;

        /* url 파싱 작업*/

        // getInPath 작업
        // split : \\, ?, * 과 같은 특수문자는 앞에 \\로 이스케이프 처리
        // 구분자 ?를 기준으로 문자열을 잘라 전은 path
        String[] urlBits = url.split("\\?", 2);
        this.path = urlBits[0];

        // getInParam 작업업
       if (urlBits.length == 2) {
            this.queryStr = urlBits[1]; // 구분자 ?를 기준으로 후자는 쿼리스트링
        }


    }

        /* DefaultValue : compiler에 의해 초기화되는 값 */
    public int getIntParam (String paramName,int defaultValue){

        if (queryStr == null) {
            return defaultValue;
        }

        String[] bits = queryStr.split("&");

        for (String urlBit : bits) {
            String[] paramNameAndValue = urlBit.split("=", 2);
            String paramName_ = paramNameAndValue[0];
            String paramValue = paramNameAndValue[1];

            if (paramName.equals(paramName_)) {
                return Integer.parseInt(paramValue);
            }
        }

        return defaultValue;
    }

    public String getPath () {
        return path;
    }
}

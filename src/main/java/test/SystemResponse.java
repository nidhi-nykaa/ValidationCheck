package test;

import java.io.Serializable;
import java.util.Map;

public class SystemResponse {
    String code;
    String msg;

    public SystemResponse(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}

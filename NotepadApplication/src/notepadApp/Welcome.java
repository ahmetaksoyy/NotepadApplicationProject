package notepadApp;

public class Welcome {
    String okul,sinif,ders;

    //builder pattern ile constructor metodu parametereler eksik girilmesine karsi koruma altina aliyoruz


    public Welcome(Builder builder) {


        this.ders = builder.ders;
        this.sinif=builder.sinif;
        this.okul=builder.okul;


    }

    public String degis(){

        String text = "bu proje "+okul+" "+sinif+" "+ders+" projesidir";
        //ciktida null gozuksun istememedigim icin nullu siliyorum
        if (text.contains("null")){
            return text.replace("null","");
        }else{
            return text;

        }

    }


    public static class Builder{

        private String okul,sinif,ders ;
        int x = 5;
        public Builder(){ }

        public Builder okul(String okul ){

            this.okul = okul;
            return this;
        }

        public Builder sinif(String sinif){
            this.sinif = sinif;
            return this;
        }

        public Builder ders(String ders){
            this.ders = ders;
            return this;
        }

        public Welcome build(){
            return new Welcome(this);
        }

    }



}

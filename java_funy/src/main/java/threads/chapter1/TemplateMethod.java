package threads.chapter1;

public class TemplateMethod {
    public final void print(String message){
        System.out.println("#################");
        wraPrint(message);
        System.out.println("#################");
    }
    protected void wraPrint(String message){

    }
    public static void main(String[] args){
        TemplateMethod t1=new TemplateMethod(){
            @Override
            protected void wraPrint(String message){
                System.out.println("*"+message+"*");
            }
        };
        t1.print("hello thread");
        TemplateMethod t2=new TemplateMethod(){
            @Override
            protected void wraPrint(String message){
                System.out.println("+"+message+"+");
            }
        };
        t2.print("hello thread");
    }
}

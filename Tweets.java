
import tester.*;
interface Tweet{
    public boolean isStartOfThreadBy(String author);
    public int totalLikes();
    public String unrollThread();
}

class TextTweet implements Tweet{
    String contents;
    int likes;
    String author;
    public TextTweet(String contents,int likes,String author)
    {
        this.contents = contents;
        this.likes=  likes;
        this.author = author;
    }
    public boolean isStartOfThreadBy(String author){
        if(this.author.equals(author))
        {
            return true;
        }
        return false;
    }
    public int totalLikes(){
        return this.likes;
    }
    public String unrollThread(){
        String returnString = this.author+"\n"+this.likes+" likes\n"+this.contents+"\n";
        return returnString;
    }
}
class ReplyTweet implements Tweet{
    String contents;
    int likes;
    String author;
    Tweet replyTo;
    public ReplyTweet(String contents,int likes,String author,Tweet replyTo)
    {
        this.contents = contents;
        this.likes = likes;
        this.author = author;
        this.replyTo = replyTo;
    }
    public boolean isStartOfThreadBy(String author){
        if(this.author.equals(author)&&replyTo.isStartOfThreadBy(author)){
            return true;
        }
        return false;
    }
    public int totalLikes(){
        return this.likes+replyTo.totalLikes();
    }
    public String unrollThread(){
        String returnString = replyTo.unrollThread()+this.author+"\n"+this.likes+" likes\n"+this.contents+"\n";
        return returnString;
    }
}

class Tweets{
    String author = "Lam";
    int likes = 11;
    String contents = "Hello!";
    String author2 = "FJ";
    int likes2 = 10;
    String contents2 = "Hi";
    //
    TextTweet test1 = new TextTweet(contents,likes,author);
    TextTweet test2 = new TextTweet(contents2,likes2,author2);
    //test case 1:
    boolean equalAuthorTest1 = test1.isStartOfThreadBy("Lam");//expected true;
    boolean equalAuthorTest2 = test2.isStartOfThreadBy("Lam");//expected false;

    //Test case method 2:
    int totalLikesTest1 = test1.totalLikes();//expected 11;
    int totalLikesTest2 = test2.totalLikes();//expected 10;

    //Test case method 3:
    /**
     * Lam
     * 11 likes
     * Hello!
     */
    String unrollTest1 = test1.unrollThread();//expected
    
    /**
     * FJ
     * 10 likes
     * Hi
     */
    String unrollTest2 = test2.unrollThread();//expected
   
    ReplyTweet LamReply = new ReplyTweet(contents, likes, author, test1);
    ReplyTweet FJReply = new ReplyTweet(contents2, likes2, author2, test2);
    //Test case method 4:
    boolean equalAuthorTest3 = LamReply.isStartOfThreadBy(author);//expected true;
    boolean equalAuthorTest4 = FJReply.isStartOfThreadBy(author);//expected false;

    //Test case method 5:
    int totalLikesTest3 = LamReply.totalLikes();//expected 22;
    int totalLikesTest4 = FJReply.totalLikes();//expected 20;

    //Test case method 6:
    /**
     * Lam
     * 11 likes
     * Hello!
     * Lam
     * 11 likes
     * Hello!
     */
    String unrollTest3 = LamReply.unrollThread();
    /**
     * FJ
     * 10 likes
     * Hi
     * FJ
     * 10 likes
     * Hi
     */
    String unrollTest4 = FJReply.unrollThread();





}
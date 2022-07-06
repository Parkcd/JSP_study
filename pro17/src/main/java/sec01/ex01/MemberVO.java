package sec01.ex01;

import java.sql.Date;

public class MemberVO {
   private String id;
   private String pwd;
   private String name;
   private String email;
   private Date joinDate;
   
   public MemberVO() {
      System.out.println("MemberVO 생성자 호출");
   }
   
   public MemberVO(String id, String pwd, String name, String email) {
      this.id = id;
      this.pwd = pwd;
      this.name = name;
      this.email = email;
   }
   
   public MemberVO(String id, String pwd, String name, String email, Date joinDate) {
      this.id = id;
      this.pwd = pwd;
      this.name = name;
      this.email = email;
      this.joinDate = joinDate;
   }

   /**
    * @return the id
    */
   public String getId() {
      return id;
   }

   /**
    * @param id the id to set
    */
   public void setId(String id) {
      this.id = id;
   }

   /**
    * @return the pwd
    */
   public String getPwd() {
      return pwd;
   }

   /**
    * @param pwd the pwd to set
    */
   public void setPwd(String pwd) {
      this.pwd = pwd;
   }

   /**
    * @return the name
    */
   public String getName() {
      return name;
   }

   /**
    * @param name the name to set
    */
   public void setName(String name) {
      this.name = name;
   }

   /**
    * @return the email
    */
   public String getEmail() {
      return email;
   }

   /**
    * @param email the email to set
    */
   public void setEmail(String email) {
      this.email = email;
   }

   /**
    * @return the joinDate
    */
   public Date getJoinDate() {
      return joinDate;
   }

   /**
    * @param joinDate the joinDate to set
    */
   public void setJoinDate(Date joinDate) {
      this.joinDate = joinDate;
   }
}
   
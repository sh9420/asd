package com.sanhak.command;

import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.Enumeration;

import com.sanhak.dao.Dao;
import com.sanhak.dto.commonDto;
import com.sanhak.dto.indilostitemDto;
import com.sanhak.dto.memberDto;

import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.MultipartResponse;

public class UpdateIndilostitemCommand implements Command{

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) {
      // TODO Auto-generated method stub
      
      @SuppressWarnings("deprecation")
      String uploadPath = request.getRealPath("/uploads");
      System.out.println("������ : " + uploadPath);
      
      int maxSize = 1024 * 1024 * 10;
   
      HttpSession session = request.getSession();
      memberDto mdto = (memberDto)session.getAttribute("Lresult");
      
      java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      String today = formatter.format(new java.util.Date());

       //file parameter
       String pathImg = ""; // �ߺ�ó���� �̸�
       String originalpathImg = ""; // �ߺ� ó���� ���� ���� �̸�
       long fileSize = 0; // ���� ������
       String fileType = ""; // ���� Ÿ��
           
       MultipartRequest multi = null;
       
       try {
         multi = new MultipartRequest(request,uploadPath,maxSize,"UTF-8",new DefaultFileRenamePolicy());
         
         //get parameter
         System.out.println("�ۼ��� : "+mdto.getMid());
         request.setCharacterEncoding("utf-8");
         
         int inum = Integer.parseInt(multi.getParameter("inum"));
         String mid = mdto.getMid();
         String postdate = today;
         String title = multi.getParameter("title");
         String iprdtname = multi.getParameter("iprdtname");
         int hor = Integer.parseInt(multi.getParameter("hor"));
         String lstdate = multi.getParameter("lstdate");
         String ilocation = multi.getParameter("ilocation");
         String iplace = multi.getParameter("iplace");
         String isector = multi.getParameter("isector");
         String iprdtid = multi.getParameter("iprdtid");
         String iunique = multi.getParameter("iunique");
         
         //������ ��ü �����̸����� ������
         Enumeration files = multi.getFileNames();
         
         while(files.hasMoreElements()) {
            //form �±׿��� <input type="file" name="���⿡ ������ �̸�"/> �� �����´�.
            String file1 = (String)files.nextElement();
            //�׿� �ش��ϴ� ���� ���� �̸��� �����´�.
            originalpathImg = multi.getOriginalFileName(file1);
            //���� ���� �ߺ��� ��� �ߺ� ��å�� ���� �ڿ� 1,2,3 ó�� �پ� unique �ϰ� ���ϸ��� �����ϴµ� �̶� ������ �̸��� filesystemName�̶� �Ͽ� �� �̸� ������ �����´�.(�ߺ��� ���� ó��)
            pathImg = multi.getFilesystemName(file1);
            //���� Ÿ�� ������ ������
            fileType = multi.getContentType(file1);
            //input tile name �� �ش��ϴ� ���� ������ ������
            File file = multi.getFile(file1);
            //�� ���� ��ü�� ũ�⸦ �˾Ƴ�
            fileSize = file.length();
            pathImg = "uploads/"+ pathImg;
            session.setAttribute("img", pathImg );
         }
         indilostitemDto dto = new indilostitemDto();
         
         dto.setHor(hor);
         dto.setIlocation(ilocation);
         dto.setIplace(iplace);
         dto.setIprdtid(iprdtid);
         dto.setIprdtname(iprdtname);
         dto.setIsector(isector);
         dto.setIunique(iunique);
         dto.setLstdate(lstdate);
         dto.setMid(mid);
         dto.setPathImg(pathImg);
         dto.setPostdate(postdate);
         dto.setTitle(title);
         dto.setInum(inum);
         
         System.out.println(dto.toString());
         
         Dao dao = new Dao();
         dao.updateIndilostitem(dto);
         

      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

   }


}
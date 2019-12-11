<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" >

<head>
  <meta charset="UTF-8">
  <title>Animated Login and Sign up</title>
  <link href="https://fonts.googleapis.com/css?family=Montserrat:300, 400, 500" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">

  
  
      <link rel="stylesheet" href="css/login_style1.css">
      <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
      <script>
function passwordCheckFunction() {
	var userPassword1 = $('#userPassword1').val();
	var userPassword2 = $('#userPassword2').val();
	if(userPassword1!=userPassword2){
		$('#passwordCheckMessage').html('비밀번호가 일치하지않습니다.');
	}else{
		$('#passwordCheckMessage').html('');
	}
}
</script>

</head>

<body>

  <!--
  This was created based on the Dribble shot by Deepak Yadav that you can find at https://goo.gl/XRALsw
  I am @hurickkrugner on Twitter or @hk95 on GitHub. Feel free to message me anytime.
-->

<section class="user">
  <div class="user_options-container">
    <div class="user_options-text">
      <div class="user_options-unregistered">
        <h2 class="user_unregistered-title">회원가입을 안하셨나요?</h2>
        <p class="user_unregistered-text">버튼을 눌러 회원가입을 하세요!</p>
        <button class="user_unregistered-signup" id="signup-button">Sign up</button>
      </div>

      <div class="user_options-registered">
        <h2 class="user_registered-title">이미 회원 이신가요?</h2>
        <p class="user_registered-text">버튼을 눌러 로그인을 하세요!</p>
        <button class="user_registered-login" id="login-button">Login</button>
      </div>
    </div>
    
    <div class="user_options-forms" id="user_options-forms">
      <div class="user_forms-login">
        <h2 class="forms_title">Login</h2>
        <form class="forms_form" action="login.do" method="post" id="Login">
          <fieldset class="forms_fieldset">
            <div class="forms_field">
              <input type="text" placeholder="ID" class="forms_field-input" name="id" required autofocus />
            </div>
            <div class="forms_field">
              <input type="password" placeholder="Password" class="forms_field-input" name="password" required />
            </div>
          </fieldset>
          <div class="forms_buttons">
            <input type="submit" value="Log In" class="forms_buttons-action">
          </div>
        </form>
      </div>
      <div class="user_forms-signup">
        <h2 class="forms_title">Sign Up</h2>
        <form class="forms_form" action="join.do" method="post" id="SignUp">
          <fieldset class="forms_fieldset">
          
            <div class="forms_field">
              <input type="text" placeholder="id" class="forms_field-input" name="id"required />
            </div>
            <div class="forms_field">
              <input type="password" placeholder="Password" id="userPassword1" onkeyup="passwordCheckFunction();" class="forms_field-input" name="password" required />
            </div>
            <div class="forms_field">
              <input type="password" placeholder="Password check" id="userPassword2" onkeyup="passwordCheckFunction();"  class="forms_field-input" name="password2"required />
             <h1 style="color: red;" id="passwordCheckMessage"> </h1>
            </div>
             <div class="forms_field">
              <input type="text" placeholder="name" class="forms_field-input" name="name"required />
            </div>
            <div class="forms_field">
              <input type="text" placeholder="phone number" class="forms_field-input" name="mtel"required />
            </div>
            <div class="forms_field">
              <input type="email" placeholder="Email" class="forms_field-input" name="email" required />
            </div>
            
          </fieldset>
         
          <div class="forms_buttons">
            <input type="submit" value="Sign up" class="forms_buttons-action">
          </div>
          
        </form>
      </div>
    </div>
  </div>
</section>
  
  

    <script  src="js/login_index.js"></script>
    

		
</body>

</html>



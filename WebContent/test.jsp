<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
@charset "utf-8";

/* 메인퀵메뉴 */
#main{}
.main_qnb{margin:0 auto;width:1260px;}
.main_qnb2{clear:both;margin:0 auto;width:1260px;margin-top:100px;}
.qnb{float:left; position:relative;max-width:314px;height:269px;background:#fff;border-top:1px solid #dadada;border-right:1px solid #dadada;}
.qnb4{float:left; position:relative;max-width:314px;width:314px;height:268px;background:#fff;border-top:1px solid #dadada;border-bottom:1px solid #dadada;border-left:1px solid #dadada;}
.qnb5{float:left; position:relative;max-width:620px;height:260px;background:#fff;border:5px solid #96b5dc;}
.qnb6{float:left; position:relative;max-width:314px;height:268px;background:#fff;border-top:1px solid #dadada;border-bottom:1px solid #dadada;border-right:1px solid #dadada;}
.qnb_h1{font-size:22px;color:#333;padding-left:26px;padding-top:29px;font-weight:bold;}
.qnb5 h1{font-size:22px;color:#2d6bba;padding-left:26px;padding-top:29px;font-weight:bold;}
.qnb5 .sideText{font-size:12px;position: absolute;right:60px;top:6px;padding-top:19px;}
.qnb_span{display:inline-block;font-size:14px;color:#333;padding-left:26px;padding-right:25px;padding-top:12px;line-height:18px;}
.qnb_a{display:block;background:#fff;width:312px;height:268px;cursor:pointer;}
.qnb_a:hover{display:block;width:312px;height:268px;background:#fafaff;}
.qnb_a p {text-align:right;background:#ccc;vertical-align:bottom;}
.qnb_a p img{vertical-align:bottom;position:absolute;left:185px;bottom:14px;}
#main_qnb:after{content:""; display:block; clear:both;}

/* 습득물 상세 검색 */
.lost_qfind .qnb5_l {float:left;width:308px;margin-top:10px;}
.lost_qfind .qnb5_r {float:right;width:308px;margin-top:10px;}
.lost_qfind .lost_inputbox {width:310px;height:26px;padding-left:26px;display:block;margin-top:7px;}
.lost_qfind label {display:inline-block;padding:0;font-size:13px;color:#333;font-weight:bold;margin-right:5px;width:65px;vertical-align:top;padding-top:5px;}
.lost_qfind input,select {border:1px solid #d6d6d6;height:24px;width:152px;margin-right:5px;vertical-align:top;}
.lost_qfind p{clear:both;display:block;text-align:center;padding-top:16px;}
.lost_qfind p .qnb5_submit{border:0; width:78px; height:36px;overflow:hidden; background:#2d6bba;cursor:pointer;color:#fff;font-weight:bold;padding-bottom:5px;}

/* 달력팝업 */
.lost_qfind .lost_period {width:700px;height:26px;margin-top:7px;padding-left:26px;display:block;}
.lost_qfind .lost_period input {width:152px;margin-right:1px;}
.lost_qfind .lost_period span{display:inline-block;margin:0;padding:0;vertical-align:top;padding-top:4px;text-align:center;width:20px;}

/* 종류팝업 */
.find_kindPop{width:800px;height:600px;position:absolute;z-index:9999;top:300px;left:550px;background:#fff;border:1px solid #ccc;}

/* 최근 등록 습득물 (메인화면 구성) */
#latest_list{clear:both;position:relative;margin:0 auto;width:1260px;margin-bottom:20px;margin-top:20px;height:250px;}
#latest_list h1{font-size:18px;color:#333;padding-left:26px;padding-top:29px;font-weight:bold;}
#latest_list .latest_listwrap{position:relative;width:1100px;margin:0 auto;height:190px;overflow:hidden;}
#latest_list ul{position:absolute;margin-top:16px;width:1100px;height:190px;}

#latest_list li{float:left;width:200px;height:190px;padding:0 10px;text-align:center;}

#latest_list img{width:150px;height:122px;background:#fff;padding:2px;border:1px solid #ccc;}

#latest_list .latest_list_name{font-family:돋움,Dotum;font-weight:bold;font-size:12px;padding-top:2px;}
#latest_list .latest_list_date{font-family:돋움,Dotum;font-size:12px;padding-top:2px;}
#latest_list .list_prev{display:block;position:absolute;top:40%;left:0;width:31px;height:51px;background:url(https://www.lost112.go.kr/images/home/common/latest_list_arrow_l.png) no-repeat 0 0;text-indent:-9999px;overflow:hidden;}
#latest_list .list_next{display:block;position:absolute;top:40%;right:0;width:31px;height:51px;background:url(https://www.lost112.go.kr/images/home/common/latest_list_arrow_r.png) no-repeat 0 0;text-indent:-9999px;overflow:hidden;}
#latest_list:after{content:""; display:block; clear:both;}
.latest_list_date em{padding-left:5px;}
#imgList{width:800px;}


/* 게시판 탭메뉴 */
#main_board{margin:0 auto;width:1260px;height:270px;border: 1px solid #dadada;}
.notice_tab {position:relative;float:left;width:460px;height:210px;margin-top:30px;height:210px;border-right:1px solid #dadada;}
.notice_tab .notice_title{float:left;font-size:20px;font-weight:bold;margin-left:30px;}
.notice_tab .notice_title a:hover{color:#2d6bba;}
.notice_tab ul.tabcontent{position:absolute;left:20px;top:50px;width: 430px;}
.notice_tab ul li{font-size:14px;color:#333;padding-bottom:6px;}
.notice_tab ul li a{display:block;margin-bottom: 6px;padding-left: 9px;
text-overflow:ellipsis;position: relative;overflow: hidden;white-space: nowrap;}
.notice_tab .morebtn{font-size:14px;position: absolute;right:20px;top:6px;}


/* 팝업존 */
#main_board aside{float:left;max-width:298px;height:270px;padding-left:40px;overflow:hidden;}
#main_board aside h3{font-size:22px;color:#2d6bba;font-weight:bold;padding-top:30px;}
#main_board aside .pop_zone{position:relative;top:-16px;float:left;width:260px;height:200px;}
#main_board aside .pop_zone .btn_control{position:absolute;right:0px;top:2px;z-index:2;}
#main_board aside .pop_zone .btn_control button{display:block;float:left;text-indent:-9999px;background:url(/images/home/main/btn_control.png) no-repeat 0 0;width:16px;height:16px;overflow:hidden;}
#main_board aside .pop_zone .btn_control button.pop_prev {background-position: 0 0;}
#main_board aside .pop_zone .btn_control button.pop_play {background-position: -15px 0;}
#main_board aside .pop_zone .btn_control button.pop_stop {background-position: -30px 0;}
#main_board aside .pop_zone .btn_control button.pop_next {background-position: -45px 0;width:16px;}
#main_board aside .pop_zone .btn_control button.pop_list {background-position: -61px 0;}
.pop_zone .image_zone{width:258px;height:140px;padding-top:162px;}
.pop_zone .image_zone>li{float:left;}
.pop_zone .image_zone>li>a{position:absolute;display:block;width:258px;height:160px;top:0;margin-top:24px;left:0;z-index:1;}
.pop_zone .image_zone>li img{display:block;width:258px;height:160px;border:1px solid #aeadad;}
.pop_zone .image_zone>li button{display:inline-block;z-index:2;min-width:10px;background:#f9f9fb;
border:1px solid #cccdcf;border-left:none;font-size:10px;color:#6d6d6d;height:14px;letter-spacing:-1px;
margin-top:30px;}
.pop_zone .image_zone>li:first-child button{border-left:1px solid #cccdcf;}
.pop_zone .image_zone>li.on button{background:#6d6d6d;color:#fff;}
.pop_zone .pop_list_txt{display:none;position:absolute;top: 20px;left:19px;width: 200px;height:150px;overflow-y:auto;border:2px solid #dfdfdf;background:#fff;z-index:10;}
.pop_zone .pop_list_txt li{padding:10px;border-bottom:1px dotted #c6c6c6;font-size:12px;}
#main_board:after{content:""; display:block; clear:both;}

/* 메인하단 사이트맵 */
#main_sitemap{margin:0 auto;width:1260px;height:340px;margin-top:20px;background:#2d6bba;}
#main_sitemap .depth2{font-weight:bold;padding-top:34px;padding-left:40px;font-size:18px;}
#main_sitemap .depth2 li{float:left;padding-right:72px;}
#main_sitemap .depth2 li a{color:#fff;}
#main_sitemap .depth2 li a:hover{text-decoration:underline;}
#main_sitemap .depth2 li .depth3{margin-top:26px;}  
#main_sitemap .depth2 li .depth3 li{clear:both;padding:4px 0;} 
#main_sitemap .depth2 li .depth3 li a{font-weight:normal;font-size:14px;color:#fff;}
#main_sitemap:after{content:""; display:block; clear:both;}

/* 서브 사이트맵 */
#sub_sitemap{margin:0 auto;width:1260px;height:578px;margin-top:20px;border:3px solid #2d6bba;}
#sub_sitemap h1{font-size:20px;font-weight:bold;text-align:center;margin-top:20px;padding-bottom:20px;border-bottom:1px solid #2d6bba;color:#2d6bba;}
#sub_sitemap ul.depth2{width:1260px;margin:0 auto;font-weight:bold;padding-top:34px;font-size:18px;}
#sub_sitemap ul.depth2{margin: 0 20px;}
#sub_sitemap .depth2>li{float:left;text-align:center;width:184px;margin:0 8px;}
#sub_sitemap .depth2>li span{margin-top:5px; display: block;}
#sub_sitemap .depth2>li a {color:#2d6bba;}
#sub_sitemap .depth2>li a:hover{color:#2d6bba;text-decoration:underline;}
#sub_sitemap .depth2>li>ul{margin-top:26px;text-align:left;}  
#sub_sitemap .depth2>li>ul>li{clear:both;padding:2px 0;} 
#sub_sitemap .depth2>li>ul>li a{font-weight:normal;font-size:14px;color:#333;}
.depth3_1{padding-left:28px;}
.depth3_2{padding-left:33px;}
.depth3_3{padding-left:35px;}
.depth3_4{padding-left:57px;}
.depth3_5{padding-left:56px;}
.depth3_6{padding-left:49px;}
#sub_sitemap:after{content:""; display:block; clear:both;}

/* 메인배너 */
.main_banner_wrap2 {float:left;height:270px;background:#2d6bba;overflow:hidden;}
.main_banner_wrap2 .main_banner {position:relative;margin:0 auto;width:315px;height:270px;}
.main_banner_wrap2 .main_banner button:focus{outline:1px dotted #fff;overflow:hidden;}
.main_banner_wrap2 .main_visual .banner li{display:none;position:absolute;top:0;left:0;*zoom:1;width:100%;}
.main_banner_wrap2 .main_visual .banner li:after{content:"";display:block;clear:both;width:0px;height:0px;}
.main_banner_wrap2 .main_visual .banner li>img{width:315px;height:270px;float:left;padding-right:30px;}
.main_banner_wrap2 .main_visual .banner li>div{position:relative;padding-right:180px;color:#fff;}
.main_banner_wrap2 .main_visual .banner li>div .div_subject{font-size:18px;font-weight:normal;margin-bottom:3px;overflow:hidden;text-overflow:ellipsis;white-space:nowrap;}
.main_banner_wrap2 .main_visual .banner li>div .div_content{height:100px;overflow-y:auto;color:#c4cad7;line-height:14px;}
.main_banner_wrap2 .main_visual .banner li>div .div_content p {padding-top:3px;line-height:130%;}
.main_banner_wrap2 .rolling_btn{position:absolute;top:0px;right:0;z-index:10;}
.main_banner_wrap2 .rolling_btn li{float:left;margin-right:4px;margin-top:8px;}
.main_banner_wrap2 .rolling_btn .menu li button{display:block;width:15px;height:15px;background:url(/images/home/main/main_banner_dot2.png) no-repeat 0 0;text-indent:-9999px;overflow:hidden;}
.main_banner_wrap2 .rolling_btn .menu li button.on{background-position:0 -15px;}
.main_banner_wrap2 .rolling_btn .menu li button{background:#001335;border: 1px solid #aab9d3;border-radius:50%;padding:0;}
.main_banner_wrap2 .rolling_btn .menu li button.on{background:#aab9d3;border-color:#001335;}
.main_banner_wrap2 .rolling_btn .menu .stop{display:block;position:absolute;width:17px;height:16px;background:url(/images/home/main/main_banner_stop.png) no-repeat 0 0;top:250px;right:294px;text-indent:-9999px;overflow:hidden;}
.main_banner_wrap2 .rolling_btn .menu .play{display:block;position:absolute;width:17px;height:16px;background:url(/images/home/main/main_banner_play.png) no-repeat 0 0;top:250px;right:294px;/*right:274px;*/text-indent:-9999px;overflow:hidden;}
.main_banner_wrap2 .main_banner .close{display:inline-block;width:20px;height:20px;background:url(/images/home/main/main_bottom_x.png) no-repeat 0 6px;text-indent:-9999px;overflow:hidden;}
.main_banner_wrap2 .main_banner .today_close{position:absolute;color:#fff;bottom:5px;right:0;z-index:10;font-size:12px;}
.main_banner_wrap2 .main_banner .today_close>input{vertical-align:middle;}
.main_banner_wrap2 .main_banner .today_close>label{vertical-align:middle;}
.main_banner_wrap2 .main_banner_wrap:after {content:""; display:block; clear:both;}


/* 최상단 긴급공지용 슬라이드팝업(기존것 수정) */
.main_banner_wrap{height:130px;background:#2d6bba;overflow:hidden;}
.main_banner_wrap .main_banner {position:relative;margin:0 auto;width:1260px;height: 120px;margin-top:5px;}
.main_banner_wrap .main_banner button:focus{outline:1px dotted #fff;overflow:hidden;}
.main_banner_wrap .main_visual .banner li{display:none;position:absolute;top:0;left:0;zoom:1;width:100%;}
.main_banner_wrap .main_visual .banner li:after{content:"";display:block;clear:both;width:0px;height:0px;}
.main_banner_wrap .main_visual .banner li>img{width:145px;height:100px;float:left;padding-right:30px;}
.main_banner_wrap .main_visual .banner li>div{position:relative;padding-right:180px;color:#fff;}
.main_banner_wrap .main_visual .banner li>div .div_subject{font-size:18px;font-weight:normal;margin-bottom:3px;overflow:hidden;text-overflow:ellipsis;white-space:nowrap;}
.main_banner_wrap .main_visual .banner li>div .div_content{height:100px;overflow-y:auto;color:#c4cad7;line-height:14px;}
.main_banner_wrap .main_visual .banner li>div .div_content p {padding-top:3px;line-height:130%;}
.main_banner_wrap .rolling_btn{position:absolute;top:0px;right:0;padding-right:44px;z-index:10;}
.main_banner_wrap .rolling_btn li{float:left;margin-right:5px;}
.main_banner_wrap .rolling_btn .menu  li button{display:block;width:15px;height:15px;background:url(/images/home/main/main_banner_dot.png) no-repeat 0 0;text-indent:-9999px;overflow:hidden;}
.main_banner_wrap .rolling_btn .menu li button.on{background-position:-15px 0;}
.main_banner_wrap .rolling_btn .menu .stop{display:block;position:absolute;width:17px;height:16px;background:url(/images/home/main/main_banner_stop.png) no-repeat 0 0;top:0;right:22px;text-indent:-9999px;overflow:hidden;}
.main_banner_wrap .rolling_btn .menu .play{display:block;position:absolute;width:17px;height:16px;background:url(/images/home/main/main_banner_play.png) no-repeat 0 0;top:0;right:0;text-indent:-9999px;overflow:hidden;}
.main_banner_wrap .main_banner .close{display:inline-block;width:28px;height:28px;background:url(/images/home/main/main_bottom_x.png) no-repeat 0 10px;text-indent:-9999px;overflow:hidden;}
.main_banner_wrap .main_banner .today_close{position:absolute;color:#fff;bottom:5px;right:0;z-index:10;font-size:12px;}
.main_banner_wrap .main_banner .today_close>input{vertical-align:middle;}
.main_banner_wrap .main_banner .today_close>label{vertical-align:middle;}




</style>
</head>
<body>

<div id="latest_list">
		<h1>최근 등록된 습득물 현황</h1>
			<div class="latest_listwrap">
				<div id="imgList">
					<ul style="left: 0px;">
					<li>
							<a href="javascript:fn_find_detail('F2018110600000604', '1')"><img src="/lostnfs/images/uploadImg/thumbnail/20181106/20181106112204545.jpg" style="width: 130px; height: 100px;" alt="지갑"></a>
							<p class="latest_list_name"><a href="javascript:fn_find_detail('F2018110600000604', '1')">지갑</a></p>				
							<p class="latest_list_date">습득일자<em>2018-11-05</em></p>
						</li>				
					
							
					
						<li>
							<a href="javascript:fn_find_detail('F2018110600001838', '1')"><img src="/lostnfs/images/uploadImg/thumbnail/20181106/20181106040201198.jpg" style="width: 130px; height: 100px;" alt="던롭지갑, 주민등록증,운전면허증, 삼성카드,현금 등."></a>
							<p class="latest_list_name"><a href="javascript:fn_find_detail('F2018110600001838', '1')">던롭지갑, 주민등록증,운전면허증, 삼성카드,현금 등.</a></p>				
							<p class="latest_list_date">습득일자<em>2018-11-06</em></p>
						</li>	
					
						<li>
							<a href="javascript:fn_find_detail('F2018110600001598', '1')"><img src="/lostnfs/images/uploadImg/thumbnail/20181106/r_20181106030934009.jpg" style="width: 130px; height: 100px;" alt="메트로시티 카드지갑"></a>
							<p class="latest_list_name"><a href="javascript:fn_find_detail('F2018110600001598', '1')">메트로시티 카드지갑</a></p>				
							<p class="latest_list_date">습득일자<em>2018-11-06</em></p>
						</li>	
					
						<li>
							<a href="javascript:fn_find_detail('F2018110600001589', '1')"><img src="/lostnfs/images/uploadImg/thumbnail/20181106/r_20181106033836863.jpg" style="width: 130px; height: 100px;" alt="회색 파우치 "></a>
							<p class="latest_list_name"><a href="javascript:fn_find_detail('F2018110600001589', '1')">회색 파우치 </a></p>				
							<p class="latest_list_date">습득일자<em>2018-11-06</em></p>
						</li>	
					
						<li>
							<a href="javascript:fn_find_detail('F2018110600001560', '1')"><img src="/lostnfs/images/uploadImg/thumbnail/20181106/20181106030618245.jpg" style="width: 130px; height: 100px;" alt="키홀더"></a>
							<p class="latest_list_name"><a href="javascript:fn_find_detail('F2018110600001560', '1')">키홀더</a></p>				
							<p class="latest_list_date">습득일자<em>2018-11-05</em></p>
						</li>	
					
						<li>
							<a href="javascript:fn_find_detail('F2018110600001484', '1')"><img src="/lostnfs/images/uploadImg/thumbnail/20181106/20181106025948099.jpg" style="width: 130px; height: 100px;" alt="남성용 반지갑"></a>
							<p class="latest_list_name"><a href="javascript:fn_find_detail('F2018110600001484', '1')">남성용 반지갑</a></p>				
							<p class="latest_list_date">습득일자<em>2018-10-28</em></p>
						</li>	
					
						<li>
							<a href="javascript:fn_find_detail('F2018110600001481', '1')"><img src="/lostnfs/images/uploadImg/thumbnail/20181106/20181106014101826.jpg" style="width: 130px; height: 100px;" alt="bmw 검정색 카드지갑"></a>
							<p class="latest_list_name"><a href="javascript:fn_find_detail('F2018110600001481', '1')">bmw 검정색 카드지갑</a></p>				
							<p class="latest_list_date">습득일자<em>2018-11-06</em></p>
						</li>	
					
						<li>
							<a href="javascript:fn_find_detail('F2018110600001424', '1')"><img src="/lostnfs/images/uploadImg/thumbnail/20181106/r_20181106024853346.jpg" style="width: 130px; height: 100px;" alt="휴대폰"></a>
							<p class="latest_list_name"><a href="javascript:fn_find_detail('F2018110600001424', '1')">휴대폰</a></p>				
							<p class="latest_list_date">습득일자<em>2018-11-06</em></p>
						</li>	
					
						<li>
							<a href="javascript:fn_find_detail('F2018110600001410', '1')"><img src="/lostnfs/images/uploadImg/thumbnail/20181106/r_20181106051402502.jpg" style="width: 130px; height: 100px;" alt="532호 시계"></a>
							<p class="latest_list_name"><a href="javascript:fn_find_detail('F2018110600001410', '1')">532호 시계</a></p>				
							<p class="latest_list_date">습득일자<em>2018-10-21</em></p>
						</li>	
					
						<li>
							<a href="javascript:fn_find_detail('F2018110600001408', '1')"><img src="/lostnfs/images/uploadImg/thumbnail/20181106/r_20181106051810326.jpg" style="width: 130px; height: 100px;" alt="607호 귀걸이 한쪽, 립스틱"></a>
							<p class="latest_list_name"><a href="javascript:fn_find_detail('F2018110600001408', '1')">607호 귀걸이 한쪽, 립스틱</a></p>				
							<p class="latest_list_date">습득일자<em>2018-10-26</em></p>
						</li>	
					
					</ul>
				</div>
			</div>
			<button type="button" class="list_prev" title="최근 등록 습득물 현황 이전" >이전</button>
			<button type="button" class="list_next" title="최근 등록 습득물 현황 다음" >다음</button>
	</div>
</body>
</html>

<script>
$('.latest_lnf .list_wrap ul').carouFredSel({
    auto: false,
    direction : 'left',
    prev: '.list_prev',
    next: '.list_next',
//    cookie  : true,
    items:{
        visible : 1
    },
    scroll :{
        items:1,
        pauseOnHover: true,		//마우스 오버
        duration : 400, 		//슬라이딩 속도
        timeoutDuration: true  	// 이벤트 발생 시간간격
    }
});		
 $('.list_prev').click(function(){
	fn_imgLeft();
});
$('.list_next').click(function(){
	fn_imgRight();
});

var old=0;
var num=0;

function fn_imgRight() {

	num = old - 1;

	if (num >= -5) {

		$("#imgList ul").animate({

			left : parseInt($("#imgList ul li").eq(0).width() * -1)

		}, 300, function() {

			$("#imgList ul").css("left", "0px");

			$("#imgList ul li").eq(0).clone().appendTo($("#imgList ul"));

			$("#imgList ul li").eq(0).remove();

		});

		old = num;

	}

}



function fn_imgLeft() {

	var leng = $("#imgList ul li").size();

	num = old + 1;

	if (num <= 0) {			

		$("#imgList ul").animate(

				{

					left : 0

				},

				300,

				function() {

					$("#imgList ul").css("left", "0px");

					//$("#imgList ul").css("left", parseInt($("#imgList ul li").eq(0).width() * -1));

					$("#imgList ul li").eq(parseInt(leng - 1)).clone().prependTo($("#imgList ul"));

					$("#imgList ul li").eq(leng).remove();

				});

		old = num;

	} 
</script>
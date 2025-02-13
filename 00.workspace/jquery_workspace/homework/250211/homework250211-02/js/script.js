$(document).ready(function(){
  $(window).scroll(function(){
    let scrollPosition = $(window).scrollTop(); // 현재 스크롤바 위치
    if(scrollPosition > 50){
      $("nav.navbar").addClass("nav-back2");
      $("nav.navbar").removeClass("nav-back1");
      $("nav.navbar-light ul.navbar-nav li:not(:last-child) a").addClass("nav-text2");
      $("nav.navbar-light ul.navbar-nav li:not(:last-child) a").removeClass("nav-text1");
      $(".navbar-brand img.logo_img1").addClass("hide");
      $(".navbar-brand img.logo_img2").removeClass("hide");
    }else{
      $("nav.navbar").removeClass("nav-back2");
      $("nav.navbar").addClass("nav-back1");
      $("nav.navbar-light ul.navbar-nav li:not(:last-child) a").addClass("nav-text1");
      $("nav.navbar-light ul.navbar-nav li:not(:last-child) a").removeClass("nav-text2");
      $(".navbar-brand img.logo_img1").removeClass("hide");
      $(".navbar-brand img.logo_img2").addClass("hide");
    }

    let scrollList = [];
    let targetOffset = $("#partner").offset().top;

    
    
    // if(scrollPosition+$(window).height() > targetOffset+$("#partner").height()){
    if(scrollPosition+$(window).height() > targetOffset){
      $("#partner").addClass("animate__animated").addClass("animate__fadeInUp");
    }
  });
});
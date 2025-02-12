$(document).ready(function(){
  $(window).scroll(function(){
    let scrollPosition = $(window).scrollTop();
    let scrollList = [];
    let targetOffset = $("#partner").offset().top;
    
    // if(scrollPosition+$(window).height() > targetOffset+$("#partner").height()){
    if(scrollPosition+$(window).height() > targetOffset){
      $("#partner").addClass("animate__animated").addClass("animate__fadeInUp");
    }
  });
});
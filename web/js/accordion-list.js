(function($){
 $.fn.accordion_list=function(o){ 

    var getParametrs = {
        sliding_speed:500
    }

    $.extend(getParametrs, o); 

    var _this = $(this),
        objectWidth = _this.width(),
        objectHeight = _this.height(),
        curentIndex = $('li', _this).length;
    ;   
///////////////////////init////////////////////////////
  init();
  function init(){

    $('>li', _this).css({'position':'relative', 'display':'block'})

    _this.each(function(){
      $('>li ._description', _this).stop().slideUp(0);
    })

    addEventHandler();
  }//end init
//////////////addButonsEventHandler///////////////////
  function addEventHandler(){
      $('>li ._btn', _this).click(
        function(){
          
          if($(this).parent().index()!==curentIndex){
            $('>li', _this).eq(curentIndex).find('._description').slideUp(getParametrs.sliding_speed);
            $('>li', _this).eq(curentIndex).removeClass('_active');
            curentIndex = $(this).parent().index();
            $('>li', _this).eq(curentIndex).find('._description').slideDown(getParametrs.sliding_speed);
            $('>li', _this).eq(curentIndex).addClass('_active');
          }else{
            $('>li', _this).eq(curentIndex).find('._description').slideUp(getParametrs.sliding_speed);
            $('>li', _this).eq(curentIndex).removeClass('_active');
            curentIndex = $('li', _this).length;   
          }

        }
      )
      
      $('>li ._subbtn', _this).click(
        function(){
          if($(this).parent().parent().index()!==curentIndex){
            $('>li', _this).eq(curentIndex).find('._description').slideUp(getParametrs.sliding_speed);
            $('>li', _this).eq(curentIndex).removeClass('_active');
            curentIndex = $(this).parent().parent().index();
            $('>li', _this).eq(curentIndex).find('._description').slideDown(getParametrs.sliding_speed);
            $('>li', _this).eq(curentIndex).addClass('_active');
          }else{
            $('>li', _this).eq(curentIndex).find('._description').slideUp(getParametrs.sliding_speed);
            $('>li', _this).eq(curentIndex).removeClass('_active');
            curentIndex = $('li', _this).length;   
          }

        }
      )
  }//end addEvent
//////////////////////////////////////////////////////         
 }
})(jQuery)
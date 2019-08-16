layui.use(['element'], function(){
	$ = layui.jquery;
  	element = layui.element(); 
  
  //导航的hover效果、二级菜单等功能，需要依赖element模块
  // larry-side-menu向左折叠
  if($(window).width()<750){
		trun = 0;
	}else{
		trun = 1;
	}
  	//监听导航点击
  	element.on('nav(side)', function(elem){
    	title = elem.find('cite').text(); //二级菜单被点击，获得菜单内容
    	url = elem.find('a').attr('_href'); //获得点击的a标签的_href属性作为要显示的html
    	//alert(url);

    	for (var i = 0; i <$('.x-iframe').length; i++) {
    		if($('.x-iframe').eq(i).attr('src')==url){
    			element.tabChange('x-tab', i);
    			return;
    		}
    	};

    	res = element.tabAdd('x-tab', {
	        title: title
	        ,content: '<iframe frameborder="0" src="'+url+'" class="x-iframe"></iframe>'
		    });

		element.tabChange('x-tab', $('.layui-tab-title li').length-1);

    	$('.layui-tab-title li').eq(0).find('i').remove();
  });
});



    <html>  
      <head>  
            <title>freemarker测试</title>  
        </head>  
        <body> 
        	<#-- 注释部分 --><br> 
        	<#-- 下面使用插值 --> 
            <h1>${message}</h1> 
            <h1>
            	<#--使用list指令-->
            	<#list ["星期一","星期二","星期三"] as day>
            		${day}<br> 
            	</#list>
            </h1>
        </body>  
    </html>  
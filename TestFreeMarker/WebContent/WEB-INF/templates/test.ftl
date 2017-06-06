    <html>  
      <head>  
            <title>freemarker测试</title>  
        </head>  
        <body> 
        	<#-- 注释部分 --><br> 
        	<#-- 下面使用插值 --> 
            <h1>${message}</h1> 
           
            <#--使用list指令-->
            <#--指令中list 列表  as 条目--> 
            <#--条目_index表示当前条目在列表中索引-->
            <#--条目_has_next表示列表中有无下一个值-->
            <h1>
            	<#list ["星期一","星期二","星期三"] as day> 
            		${day_index}:
            		${day},
            		<#if day_has_next>
            			"还有下一个"
            		<#else>
            			"没有下一个"
            		</#if>
            		<br>
            	</#list>
            </h1>
            
            <#--使用if指令-->
            <#assign age=23>
            <h1>
            <#if (age > 60)>
            	老年人
            <#elseif (age > 40)>
            	中年人
            <#elseif (age > 20)>
            	青年人
            <#else>
            	少年人
            </#if>
            </h1>
            <#include "1.ftl">
        </body>  
    </html>  
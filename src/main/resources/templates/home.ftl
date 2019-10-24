<#import "parts/common.ftl" as a>
<@a.page>
    <#list rss as rs>
        <div class="card p-3 mb-5 shadow">
            ${rs.description}
        </div>
    </#list>
</@a.page>
<#import "parts/common.ftl" as a>
<@a.page>
    <#list rss as rs>
        <div class="card p-3 mb-5 shadow">
            <h1 class="mb-3">${rs.title}</h1>
            ${rs.description}
            <p class="mt-3">${rs.publishData}</p>
        </div>
    </#list>
</@a.page>
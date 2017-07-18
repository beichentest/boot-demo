<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<%-- <input type="hidden" id="pageNumber" name="pageNumber" value="${pageInfo.pageNum}" />
<input type="hidden" id="pageSize" name="pageSize" value="${pageInfo.pageSize}" />
<input type="hidden" id="sortColumns" name="sortColumns" /> --%>

<table class="gridtable" style="width: 100%; text-align: center;">
	<tr>
		<c:if test="${pageInfo.hasPreviousPage}">
			<td><a href="javascript:void(0)" onclick="togglePage(1);">首页</a>
			</td>
			<td><a href="javascript:void(0)" onclick="togglePage(${pageInfo.prePage});">前一页</a>
			</td>
		</c:if>
		<c:forEach var="nav" items="${pageInfo.navigatepageNums}"
			varStatus="status">
			<c:if test="${nav==pageInfo.pageNum}">
				<td style="font-weight: bold;">${nav}</td>
			</c:if>
			<c:if test="${nav!=pageInfo.pageNum}">
				<td><a href="javascript:void(0)" onclick="togglePage(${nav});">${nav}</a>
				</td>
			</c:if>
		</c:forEach>
		<c:if test="${pageInfo.hasNextPage}"> 
			<td><a href="javascript:void(0)" onclick="togglePage(${pageInfo.nextPage});">下一页</a>
			</td>
			<td><a href="javascript:void(0)" onclick="togglePage(${pageInfo.pages});">尾页</a>
			</td>
		</c:if>
	</tr>
</table>

<script type="text/javascript">    
    function togglePage(page) {
        if(page) {
            if(isNaN(page)) {
                alert('页码请输入数字');
            }
            else {
                var ele = $('#page').get(0);
                if(ele) {
                    ele.value = page;
                    if(ele.form.onPageTurn && (ele.form.onPageTurn(ele.form) == false))
                        return;
                    ele.form.submit();
                }
            }
        }
    }
</script>
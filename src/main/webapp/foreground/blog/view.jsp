<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<div class="data_list">
    <div class="data_list_title">
        <img src="/static/images/blog_show_icon.png"/>
        博客信息
    </div>
    <div>
        <div class="blog_title"><h3><strong>${blog.title }</strong></h3></div>
        <div class="blog_info">
            发布时间：『 <fmt:formatDate value="${blog.releaseDate }" type="date" pattern="yyyy-MM-dd HH:mm"/>』&nbsp;&nbsp;博客类别：${blog.blogType.typeName }&nbsp;&nbsp;阅读(${blog.clickHit }) 评论(${blog.replyHit })
        </div>
        <div class="blog_content">
            ${blog.content }
        </div>
    </div>
</div>
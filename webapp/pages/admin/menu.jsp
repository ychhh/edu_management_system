<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="col-md-2">
    <ul class="nav nav-pills nav-stacked" id="nav">
        <li><a href="/adminAddCourse">课程管理<span class="badge pull-right">${courseCount}</span></a></li>
        <li><a href="/adminAddStudent">学生管理<span class="badge pull-right">${studentCount}</span></a></li>
        <li><a href="/adminShowTeacher">教师管理<span class="badge pull-right">${teacherCount}</span></a></li>
        <li><a href="/adminUserPasswordRest">账号密码重置<sapn class="glyphicon glyphicon-repeat pull-right" /></a></li>
        <li><a href="/adminPasswordRest">修改密码<sapn class="glyphicon glyphicon-pencil pull-right" /></a></li>
        <li><a href="/logout">退出系统<sapn class="glyphicon glyphicon-log-out pull-right" /></a></li>
        <li class="disabled"><a href="##">Responsive</a></li>
    </ul>
</div>
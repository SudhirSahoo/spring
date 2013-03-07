<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<link rel="stylesheet" href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css" />
	<script src="http://code.jquery.com/jquery-1.8.3.js"></script>
	<script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
	
<style>
.error {
color: #ff0000;
font-style: italic;
}
</style>

<script>
	$(function() {
		$("#taskCreatedDate").datepicker({dateFormat: 'dd-M-yy', minDate: new Date }).val();;
		$("#taskStartDate").datepicker({dateFormat: 'dd-M-yy', minDate: new Date }).val();;
		$("#taskEndDate").datepicker({dateFormat: 'dd-M-yy', minDate: new Date }).val();;
		$("#taskDueDate").datepicker({dateFormat: 'dd-M-yy', minDate: new Date }).val();;
	});
	</script>
	
<form:form method="POST" commandName="createTask" action="/TMS/task/createTask.do">

	<div class="task-section">
		<h2>Create Task</h2>

		<div class="row rqrd">
			<form:label path="taskName">
				<em>*</em>Task Name</form:label>
			<fieldset>
				<form:input type="text" value="" id="taskName" path="taskName"
					class="text" />
				<form:errors path="taskName" cssClass="error" />
				<p class="tip">
					Note: Task Name will be appended with current day, month and year.
					<a>help</a>
				</p>
			</fieldset>
		</div>
		<div class="row rqrd">
			<form:label path="taskDesc">
				<em>*</em>Task Description</form:label>
			<fieldset>
				<form:textarea type="text" value="" id="taskDesc" path="taskDesc"
					class="textarea" />
			</fieldset>
		</div>
		
		<div class="row rqrd">
			<form:label path="taskStatus">
				<em>*</em>Task Status</form:label>
			<fieldset>
				<form:select path="taskStatus">
					   <form:option value="0" label="--- Select ---" />
					   <form:options items="${taskStatusMap}" />
				</form:select>
			</fieldset>
		</div>

		<div class="row rqrd">
			<form:label path="taskPriority">
				<em>*</em>Task Priority</form:label>
			<fieldset>
				<form:select path="taskPriority">
					   <form:option value="0" label="--- Select ---" />
					   <form:options items="${taskPriorityMap}" />
				</form:select>
			</fieldset>
		</div>
		
		<div class="row rqrd">
			<form:label path="taskCreatedDate">
				<em>*</em>Task Created Date</form:label>
			<fieldset>
				<form:input  value="" id="taskCreatedDate" path="taskCreatedDate"
					class="text" />
				<form:errors path="taskCreatedDate" cssClass="error" />
			</fieldset>
		</div>
		
		<div class="row rqrd">
			<form:label path="taskStartDate">
				<em>*</em>Task Start Date</form:label>
			<fieldset>
				<form:input  value="" id="taskStartDate" path="taskStartDate"
					class="text" />
				<form:errors path="taskStartDate" cssClass="error" />
			</fieldset>
		</div>
		
		<div class="row rqrd">
			<form:label path="taskEndDate">
				<em>*</em>Task End Date</form:label>
			<fieldset>
				<form:input  value="" id="taskEndDate" path="taskEndDate"
					class="text" />
				<form:errors path="taskEndDate" cssClass="error" />
			</fieldset>
		</div>
		
		<div class="row rqrd">
			<form:label path="taskDueDate">
				<em>*</em>Task Due Date</form:label>
			<fieldset>
				<form:input  value="" id="taskDueDate" path="taskDueDate"
					class="text" />
				<form:errors path="taskDueDate" cssClass="error" />
			</fieldset>
		</div>
		
		<div class="buttons">
			<input type="submit" value="Save" />
		</div>
		
	</div>

</form:form>
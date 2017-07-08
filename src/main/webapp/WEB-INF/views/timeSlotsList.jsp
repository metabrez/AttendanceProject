<%@include file="/WEB-INF/views/template/header.jsp"%>


<div class="container-wrapper">
	<div class="container">
		<div id="login-box">

			<div>
				<a href="courseOfferingList">Course Offerings</a>
			</div>
			<h2>Students Detailed Information</h2>

			<table class="table table-striped table-hover" border="1">

				<thead>
					<tr class="bg-success">
						<!-- <th>Photo Thumb</th> -->
						<th>title</th>
						<th>Begin Time</th>
						<th>End Time</th>


					</tr>

				</thead>
				<c:forEach items="${timeSlots}" var="timeSlot">

					<tr>

						<td>${timeSlot.title}</td>
						<td>${timeSlot.beginTime}</td>
						<td>${timeSlot.endTime}</td>

					</tr>
				</c:forEach>
			</table>

		</div>
	</div>
</div>
<%@include file="/WEB-INF/views/template/footer.jsp"%>
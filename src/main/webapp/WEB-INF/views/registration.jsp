<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sales Form</title>

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css" />

<script src="https://code.jquery.com/jquery-2.2.4.js"
	integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI="
	crossorigin="anonymous"></script>
<script
	src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/2.4.0/jspdf.umd.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jspdf-autotable/3.5.13/jspdf.plugin.autotable.min.js"></script>

</head>


<body>
	<c:if test="${msg ne null}">
		<div class="alert alert-success" id="alId">${msg}</div>
	</c:if>

	<c:if test="${dmsg ne null}">
		<div class="alert alert-danger" id="dlId">${dmsg}</div>
	</c:if>

	<div class="container mt-5">
		<div class="h2 text-center text-primary">Mark Entry Form</div>
		<div class="card">

			<div class="card-body">
				<form action="./registerMark" method="post"
					enctype="multipart/form-data">
					<div class="container" id="cId">
						<div class="row">

							<div class="col-3">
								<label for="batchName">Select Batch*:</label> <select
									class="form-control" id="batchId" name="club.clubId">
									<option value="0">Select Batch</option>
									<c:forEach items="${bList}" var="batch">
										<option value="${batch.batchId}">${batch.batchName}</option>
									</c:forEach>
								</select>
							</div>

							<div class="col-3">
								<label for="clubName">Select Technology*:</label> <select
									class="form-control" id="techId" name="club.clubId">
									<option value="0">Select Technology</option>
									<c:forEach items="${tList}" var="tech">
										<option value="${tech.technologyId}">${tech.technologyName}</option>
									</c:forEach>
								</select>
							</div>


							<div class="col-3">
								<label for="emploeeName">Select Employee Name*:</label> <select
									class="form-control" id="empNameId" name="empId">

								</select>
							</div>

							<div class="col-3">
								<label for="fNameId" class="font-weight-bold">Mark</label> <input
									type="text" class="form-control" name="mark"
									id="applicantNameId">
							</div>

						</div>
					</div>
					<br>
					<div class="mt-2 text-center">
						<input type="submit" class="btn btn-success"> <input
							type="reset" class="btn btn-warning" value="Clear">
					</div>
				</form>
			</div>
		</div>
	</div>

	<br>
	<br>

	<div class="container">
		<div class="mt-2">
			<div class="h3 text-success text-center">Registration Details</div>


			<form action="./providerFilter" method="get">
				<div class="row mb-3">
					<div class="col-md-4">
						<h5>Filter</h5>
						<label>Batch Filter</label> <select class="form-control"
							id="batchId" name="batchId">
							<option value="0">Select Batch</option>
							<c:forEach items="${bList}" var="batch">
								<option value="${batch.batchId}">${batch.batchName}</option>
							</c:forEach>
						</select>
					</div>
					<div class="col-md-2 d-flex align-items-end">
						<input type="submit" class="btn btn-info" value="search"
							class="form-control">
					</div>
					<div class="col-md-2 d-flex align-items-end">
						<a class="btn btn-secondary" href="./getForm">All Data</a>
					</div>
					<div class="col-md-2 d-flex align-items-end">
						<button id="downloadPdfBtn" class="btn btn-danger">
							<i class="fa fa-file-pdf"></i>Download as PDF
						</button>
					</div>
				</div>
			</form>

			<c:if test="${dataList ne null }">
				<table class="table table-bordered" id="vTableId">
					<thead>
						<tr>
							<th>Sl No</th>
							<th>Batch Name</th>
							<th>Batch Start Date</th>
							<th>Technology Name</th>
							<th>Employee Name</th>
							<th>Employee Phone</th>
							<th>Mark</th>

						</tr>
					</thead>
					<tbody id="registrationDetails">

						<c:forEach items="${dataList}" var="data" varStatus="counter">
							<tr>
								<td>${counter.count}</td>
								<td>${data.batchName }</td>
								<td><fmt:formatDate value="${data.batchStartDate }"
										pattern="dd/MM/yyyy" /></td>
								<td>${data.technologyName}</td>
								<td>${data.employeeName}</td>
								<td>${data.employeePhone}</td>
								<td>${data.mark}</td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</c:if>
			<c:if test="${batchDataList ne null }">
				<table class="table table-bordered" id="vTableId">
					<thead>
						<tr>
							<th>Sl No</th>
							<th>Employee Name</th>
							<th>Mark</th>
							<th>Grade</th>
							<th>status</th>

						</tr>
					</thead>
					<tbody id="registrationDetails">

						<c:forEach items="${batchDataList}" var="data" varStatus="counter">
							<tr>
								<td>${counter.count}</td>
								<td>${data.empName }</td>
								<td>${data.mark}</td>
								<td>${data.grade}</td>
								<td>${data.status}</td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</c:if>


		</div>
	</div>
	<script type="text/javascript">
		/* msg */
		$(document).ready(function() {
			setTimeout(function() {
				document.getElementById("alId").style.display = 'none';
			}, 4000);
		});

		$(document).ready(function() {
			setTimeout(function() {
				document.getElementById("dlId").style.display = 'none';
			}, 4000);
		});

		/* msg */

		/* cascade */
		$(document).ready(function() {
			$(document).on('change', '#techId', function() {
				getEmpList($(this).val(), $('#batchId').val());
			});
		});

		function getEmpList(tId, bId) {
			console.log("tech id: " + tId);
			console.log("batch id: " + bId);
			$.ajax({
				type : 'GET',
				url : 'getEmpByTechID',
				data : {
					techId : tId,
					batchId : bId
				},
				success : function(resp) {
					$('#empNameId').html(resp);
				},
				error : function(xhr, status, error) {
					console.error("AJAX Error: " + status + " - " + error);
				}
			});

		}
		/* cascade */

		/*  pagination */
		$(function() {
			$("#vTableId").dataTable({
				"lengthMenu" : [ 3, 5, 10, 15, "All" ]
			});
		});
		/* pagination */

		/* download as pdf */
		
		$('#downloadPdfBtn').click(function() {
			const { jsPDF } = window.jspdf;
			const doc = new jsPDF();
			doc.autoTable({ 
				html: '#vTableId', 
				styles: { fontSize: 12},
				margin: { top: 20 },
				headStyles: { fillColor: [162, 240, 7] }
			});
			doc.save('batch.pdf');
		});
		/* download as pdf */
	</script>

</body>
</html>

<script>
    $(document).ready(function () {
        $("#Student-nav-item").click(function () {
            $("#container").load("../Students.jsp");
        });
    });
</script>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark static-top">
    <div class="container">
        <a href="http://localhost:8080">
            <img src="${pageContext.request.contextPath}/asset/img/logo.PNG"  width="150" height="50"/>
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="#">Home
                        <span class="sr-only">(current)</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link"  href="#">Member</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" id="Student-nav-item" href="#">Students</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Contact</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

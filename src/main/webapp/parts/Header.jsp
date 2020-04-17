<script>
    $(document).on("click", "#Student-nav-item", function () { // When HTML DOM "click" event is invoked on element with ID "somebutton", execute the following function...
        $("#container").load("../Students");
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
                    <a class="nav-link" id="Student-nav-item" href="../StudentServlet?action=get">Students</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Contact</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

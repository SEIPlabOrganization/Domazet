<!DOCTYPE html>
<html>
<head>
  <link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet" type="text/css"/>
  <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.5/jquery.min.js"></script>
  <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script>
  <jsp:include page="/SecWithTeamServlet" flush="false" />
  <script>
  $(document).ready(function() {
    $("#tabs").tabs();
  });
  </script>
</head>
<body style="font-size:62.5%;">
  
<div id="tabs">
    <ul>
        <li><a href="#fragment-1">Archive</a></li>
        <li><a href="#fragment-2">My Posts</a></li>
        <li><a href="#fragment-3">Write new Post</a></li>
    </ul>
    <div id="fragment-1">
        
    </div>
    <div id="fragment-2">
        
    </div>
    <div id="fragment-3">
        <jsp:include page="/SecWithTeamServlet.jsp" flush="false" />
    </div>
</div>
</body>
</html>
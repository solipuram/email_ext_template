<style>
	body {
		background-color: #FEF9E7;
		font-family: Helvetica, sans-serif,INTER;
    box-sizing:border-box;
   
	}
  .padding{
   padding:0.3em 0;
    
}
  .align-center{
    text-align:center;
}
 
	.build__result {
    padding:8px 12px;
    width:70%;
    margin:2em auto;    
		background-color: #fff;
    border-radius:12px;
    box-shadow: 5px 5px 5px rgba(68, 68, 68, 0.6);
	}
	.build__result__container{
	          background-color: <%= (build.result == null || build.result.toString() == 'SUCCESS') ? '#27AE60' : build.result.toString() == 'FAILURE' ? '#E74C3C' : '#f4e242' %>;
	 }
  

	     .build__result__container--body{
	       border:1px solid orange;
         border-radius:20px;
         margin:12px auto;
         padding:8px;
	     }
  .build__result__container--body > table{	     
         padding:12px;
        margin:0px auto;
     
	     }
  

	     .build__result__container--footer{	      
         background-color:#89b7f0;
         margin-top:1rem;
        
	     }
    .build__result__container--footer  > a {	      
      color:#fff;
      font-size:13px;
      padding:12px;
      text-decoration:none;
	     }
</style>
<body>
	<div class="build__result">
		<div class="build__result__container align-center">
			<h3 class="build__result__container--title">
				BUILD ${build.result ?: 'COMPLETED'}
			</h3>
		</div>
		<div class="build__result__container--body  ">
			<table>      
				<tr>
					<td class="padding">URL:</td>
					<td class="padding"><a href="${rooturl}${build.url}">${rooturl}${build.url}</a></td>
				</tr>
				<tr >
					<td  class="padding">Project:</td>
					<td  class="padding">${project.name}</td>
				</tr>
				<tr>
					<td  class="padding">Date:</td>
					<td  class="padding">${it.timestampString}</td>
				</tr>
				<tr>
					<td  class="padding">Duration:</td>
					<td  class="padding">${build.durationString}</td>
				</tr>
				<tr>
					<td  class="padding">Cause:</td>
					<td  class="padding">
						<% build.causes.each() { cause -> %>
						${hudson.Util.xmlEscape(cause.shortDescription)} <% } %>
					</td>
				</tr>       
			</table>
		</div>
		<div class="build__result__container--footer align-center">
			<a href="#">Privacy</a>
			<a href="#">Home</a>
			<a href="#">Contact</a>
		</div>
	</div>
</body>

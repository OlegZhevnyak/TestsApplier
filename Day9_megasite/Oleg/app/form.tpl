<script>

 function check_form()
  {
   if (document.getElementById('login').value=='')
    {
     alert('Please, enter user login!');
     return false;
    }

   if (document.getElementById('password').value=='')
    {
     alert('Please, enter user password!');
     return false;
    }

   return true;
  }

</script>

<style>
 form { 
  margin: 0 auto; 
  padding: 50pt;
  width:250px;
 }
 p {
  text-align: center;
 }
</style>

<form action="{PAGE_URL}" method="post" onsubmit="return check_form();">
 <table border="0">
  <tr>
   <td align="right">Login:</td>
   <td align="left">
    <input type="text" name="ul" id="login" />
   </td>
  </tr>

  <tr>
   <td align="right">Password:</td>
   <td align="left">
    <input type="password" name="up" id="password" />
   </td>
  </tr>

  <tr>
   <td align="right">
    &nbsp;
   </td>
   <td align="left">
    <input type="submit" name="ug" value="Go!" />
   </td>
  </tr>

 </table>
</form>

<br>

<p>
Please read <a href="eula.txt">Terms & Conditions</a>!
</p>

<form align="center" style="padding:10px">
	<input style="font-size:12" type="button" value="Go Back" onclick="history.back()">
</form>

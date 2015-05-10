<select class="select">
                    <option value="channel">Select By Channels</option>
                     <option value="Hum-tv">Hum Tv</option>
                      <option value="ary">Ary</option>
                        <option value="geo">Geo</option>
              </select>
              <?php
              $query="SELECT `name` FROM `category`";
			  $execute=mysqli_query($conn,$query);
			  $storeArray=array();
			   while($result=mysqli_fetch_assoc($execute)){
				  $storeArray[]=$result['name'];
			   }
			  ?>
			  
			  <table id="table">
			       <th>Category</th>
                    <tr><td><a href="#"><?php echo $storeArray['0'];?></a></td></tr>
				   <tr><td><a href="#"><?php echo $storeArray['1'];?></a></td></tr>
				   <tr><td><a href="#"><?php echo $storeArray['2'];?></a></td></tr>
				   <tr><td><a href="#"><?php echo $storeArray['3'];?></a></td></tr>
				   <tr><td><a href="#"><?php echo $storeArray['4'];?></a></td></tr>
				   <tr><td><a href="#"><?php echo $storeArray['5'];?></a></td></tr>
				   <tr><td><a href="#"><?php echo $storeArray['6'];?></a></td></tr>
			
			  </table>
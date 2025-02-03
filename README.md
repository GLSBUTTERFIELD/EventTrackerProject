# EventTrackerProject
### Overview
Refried Recipes is a RESTful web service designed to capture recipes and recipe reviews. Users can add recipes they've made or would like to try, then log a review with ratings and notes after they've created and tasted the recipe. The site provides access to recipes in user-friendly ways like searching by ingredient, food type, rating, date(s) cooked, etc. Eventually, this data could be used to learn more about one's cooking and eating habits (for example, what kind of meals do I cook most during the week, how many weeks did I cook meat in the past 3 months, etc.) and provide knowledge and motivation for future food decisions.

### Description
Users have full or partial Create, Read, Update, and Delete (CRUD) functionality on the following entities:
<ul>
	<li><em>categories:</em> tags for specific kinds of meals, such as breakfast, quick, gluten free, etc. A recipe can have multiple categories.</li>
	<li><em>food types: </em>describes the type of food, such as Korean, Italian, American, etc. A recipe must have one food type.</li>
	<li><em>ingredients:</em> names of ingredients in the database with optional description and image URL.</li>
</li><li><em>recipes:</em> recipe title, description, servings, prep and cook time, directions, source, and website and image URLs. Each recipe must have one food type.</li>
<li><em>recipe ingredients:</em> ingredients (amount and unit) and notes for a specific recipe.</li> 
<li><em>reviews:</em> remarks, difficulty level, rating, and notes for the future for a specific recipe.</li>
</ul>
The following URL routes have been successfully tested on Postman (italicized routes successfully work on the front end):
<h4>Recipes</h4>
<table class="table table-bordered">
	<thead>
		<td><strong>Route</strong></td>
		<td><strong>Functionality</strong></td>
	</thead>
	<tbody>
		<tr>
			<td><em>GET api/recipes (or api/recipes/)</em></td>
			<td><em>Gets all recipes</em></td>
		</tr>
		<tr>
			<td><em>GET api/recipes/{recipeId}</em></td>
			<td><em>Gets one recipe by id</em></td>
		</tr>
		<tr>
			<td>GET api/recipes/search/{searchword}</td>
			<td>Gets all recipes containing the searchword in its title or description</td>
		</tr>
		<tr>
			<td>GET api/recipes/search/categories/{categoryId}</td>
			<td>Gets all recipes for one category by category id</td>
		</tr>
		<tr>
			<td>GET api/recipes/search/foodtypes/{foodTypeId}</td>
			<td>Gets all recipes for one food type by food type id</td>
		</tr>
		<tr>
			<td>GET api/recipes/search/reviews/greater/{rating}</td>
			<td>Gets all recipes with review ratings greater than or equal to rating</td>
		</tr>
		<tr>
			<td>GET api/recipes/search/reviews/difficulty/{keyword}</td>
			<td>Gets all recipes with review ratings containing the keyword</td>
		</tr>
		<tr>
			<td>GET api/recipes/search/reviews/datecooked/{startDate}/{endDate}</td>
			<td>Gets all recipes with review cook date(s) between the start date and end date</td>
		</tr>
		<tr>
			<td><em>POST api/recipes</em></td>
			<td><em>Creates a new recipe</em></td>
		</tr>
		<tr>
			<td><em>PUT api/recipes/{recipeId}</em></td>
			<td><em>Replaces an existing recipe by id</em></td>
		</tr>
		<tr>
			<td><em>DELETE api/recipes/{recipeId}</em></td>
			<td><em>Deletes an existing recipe by id</em></td>
		</tr>
	</tbody>
</table>

<h4>Categories</h4>
<table class="table table-bordered">
	<thead>
		<td><strong>Route</strong></td>
		<td><strong>Functionality</strong></td>
	</thead>
	<tbody>	
		<tr>
			<td>GET api/recipes/categories (or api/recipes/categories/)</td>
			<td>Gets all categories</td>
		</tr>
		<tr>
			<td>POST api/recipes/categories</td>
			<td>Creates a new category</td>
		</tr>
	</tbody>
</table>	

<h4>Food Types</h4>
<table class="table table-bordered">
	<thead>
		<td><strong>Route</strong></td>
		<td><strong>Functionality</strong></td>
	</thead>
	<tbody>	
		<tr>
			<td>GET api/recipes/foodtypes (or api/recipes/foodtypes/)</td>
			<td>Gets all food types</td>
		</tr>
		<tr>
			<td>POST api/recipes/foodtypes</td>
			<td>Creates a new foodtype</td>
		</tr>
	</tbody>
</table>

<h4>Ingredients</h4>
<table class="table table-bordered">
	<thead>
		<td><strong>Route</strong></td>
		<td><strong>Functionality</strong></td>
	</thead>
	<tbody>	
		<tr>
			<td>GET api/ingredients (or api/ingredients/)</td>
			<td>Gets all ingredients</td>
		</tr>
		<tr>
			<td>GET api/ingredients/{ingredientId}</td>
			<td>Gets one ingredient by id</td>
		</tr>
		<tr>
			<td>GET api/ingredients/search/{keyword}</td>
			<td>Gets one ingredient by keyword</td>
		</tr>
		<tr>
			<td>POST api/ingredients</td>
			<td>Creates a new ingredient</td>
		</tr>
		<tr>
			<td>PUT api/ingredients/{ingredientId}</td>
			<td>Replaces an existing ingredient by id</td>
		</tr>
	</tbody>
</table>

<h4>Recipe Ingredients</h4>
<table class="table table-bordered">
	<thead>
		<td><strong>Route</strong></td>
		<td><strong>Functionality</strong></td>
	</thead>
	<tbody>	
		<tr>
			<td>GET api/recipes/{recipeId}/ingredients</td>
			<td>Gets all recipe ingredients by recipe id</td>
		</tr>
		<tr>
			<td>POST api/recipes/{recipeId}/ingredients</td>
			<td>Creates a new recipe ingredient/adds to recipe by id</td>
		</tr>
		<tr>
			<td>PUT api/recipes/{recipeId}/ingredients/{ingredientId}</td>
			<td>Replaces an existing recipe ingredient by recipe id and ingredient id</td>
		</tr>
		<tr>
			<td>DELETE api/recipes/{recipeId}/ingredients/{ingredientId}</td>
			<td>Deletes an existing recipe by recipe id and ingredient id</td>
		</tr>
	</tbody>
</table>

<h4>Reviews</h4>
<table class="table table-bordered">
	<thead>
		<td><strong>Route</strong></td>
		<td><strong>Functionality</strong></td>
	</thead>
	<tbody>	
		<tr>
			<td>GET api/recipes/reviews</td>
			<td>Gets all reviews</td>
		</tr>
		<tr>
			<td>GET api/recipes/{recipeId}/reviews</td>
			<td>Gets all reviews for one recipe by recipe id</td>	
		</tr>
		<tr>
			<td>GET api/recipes/{recipeId}/reviews/{reviewId}</td>
			<td>Gets one review by review id and recipe id</td>
		</tr>
		<tr>
			<td>POST api/recipes/{recipeId}/reviews</td>
			<td>Creates a new review for a recipe by recipe by</td>
		</tr>
		<tr>
			<td>PUT api/recipes/{recipeId}/reviews/{reviewId}</td>
			<td>Replaces an existing review by review id and recipe id</td>
		</tr>
		<tr>
			<td>DELETE api/recipes/{recipeId}/reviews/{reviewId}</td>
			<td>Deletes an existing review by review id and recipe id</td>
		</tr>
	</tbody>
</table>

### Database
#### Technologies Used
MySQL/MySQL Workbench
<ul>
	<li>Schema/ER Diagram design</li>
	<li>Database creation & placing relationships</li>
	<li>Table inserts & forward engineering changes</li>
</ul> 
JPA
<ul>
	<li>Hibernate</li></ul>
	<img src="https://github.com/GLSBUTTERFIELD/EventTrackerProject/blob/main/DB/recipesdb.png?raw=true">

#### Lessons Learned
In the future, I think having more specific columns (even if that means increasing the number of columns) would allow me to manipulate each item with more detail and improve the design and flow of the front end.

### REST API
#### Technologies used
REST Controller
	<ul>
	<li>GET, POST, PUT, DELETE mappings</li>
	<li>JSON and @JsonIgnore to serialize recursion</li>
	<li>HttpServletResponse to set status codes</li>
	</ul>
	Spring Data JPA
	<ul>
	<li>Entity relationship mapping</li>
	<li>Embeddable composite primary key class</li>
	<li>JUnit tests</li>
	</ul>
	Spring Boot
	<ul>
	<li>Repository Interfaces & basic CRUD methods</li>
	<li>Service Interfaces & ServiceImpl Classes</li>
	<li>Optional Objects 
	<li>Query Builder</li>
	</ul>
	Postman

#### Lessons Learned
While I didn't mind mapping out multiple entities and their relationships, I didn't realize how much work it would cause future me. I wish I would have started with one or two entities with more specific fields as I think that would have created less work.

### JavaScript/AJAX/HTML Front End
#### Technologies Used
Chrome Dev Tools
	JavaScript
	<ul>
	<li>getElementBy</li>
	<li>appendChild</li>
	<li>XMLHttpRequest</li></ul>
	html

#### Lessons Learned
I dislike how huge my script.js is and think more time (and practice) planning out my web design and corresponding js files to make things more concise - but adding all the various elements to create a table takes up a lot of code lines.

### Angular Front End
#### Technologies Used
#### Lessons Learned

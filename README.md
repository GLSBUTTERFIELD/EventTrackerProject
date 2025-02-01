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
The following URL routes have been successfully tested on Postman:
<h4>Recipes</h4>
<table class="table table-bordered">
	<thead>
		<td><strong>Route</strong></td>
		<td><strong>Functionality</strong></td>
	</thead>
	<tbody>
		<tr>
			<td>GET api/recipes (or api/recipes/)</td>
			<td>Gets all recipes</td>
		</tr>
		<tr>
			<td>GET api/recipes/{recipeId}</td>
			<td>Gets one recipe by id</td>
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
			<td>POST api/recipes</td>
			<td>Creates a new recipe</td>
		</tr>
		<tr>
			<td>PUT api/recipes/{recipeId}</td>
			<td>Replaces an existing recipe by id</td>
		</tr>
		<tr>
			<td>DELETE api/recipes/{recipeId}</td>
			<td>Deletes an existing recipe by id</td>
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

### Implementation
<img src="https://github.com/GLSBUTTERFIELD/EventTrackerProject/blob/main/DB/recipesdb.png?raw=true">

After the initial set up, I start by mapping out my database tables. Rather than getting all the ingredients for a recipe in as a String (or TEXT in MySQL Workbench), I chose to create a separate ingredient table so I could then search for a recipe by ingredient and not have to parse through a String. I joined the recipe and ingredient tables together in a ManyToMany relationship, and Workbench created the virtual join table recipe_ingredient with a composite primary key of recipe_id and ingredient_id, and same goes for the ManyToMany relationship between category and recipe.

After forward engineering barebones test data, I created all my entities and entity tests in JPA, writing and JUnit testing the basic entity mapping first and then adding and testing the entity relationships. Following some material on composite primary keys that Rob sent me, I created an embeddable RecipeIngredientId class that implements Serializable with just the primary keys, and then embedded the RecipeIngredientId into the RecipeIngredient entity. 

I mapped full or partial CRUD functionality in my six RestControllers (and their corresponding Repositories, Services, and ServiceImpls), and tested each URL on Postman. I also added some custom query searches so users can find specific results. Finally, I went back to Workbench and tweaked some of the columns (and their corresponding data types in STS) before adding in more starter data.

### Database
## Technologies Used
## Lessons Learned

### REST API
## Technologies used
## Lessons Learned

### JavaScript/AJAX/HTML Front End
## Technologies Used
## Lessons Learned

### Angular Front End
## Technologies Used
## Lessons Learned

### Technologies & Methodologies Used
<h4>Object Relational Mapping & Object-Oriented Design</h4>
<ul>
	<li>SpringToolSuite</li>
	<li>REST Controller</li>
	<ul>
		<li>GET, POST, PUT, DELETE mappings</li>
		<li>JSON and @JsonIgnore to serialize recursion</li>
		<li>HttpServletResponse to set status codes</li>
	</ul>
	<li>Spring Data JPA</li>
	<ul>
		<li>Entity relationship mapping</li>
		<li>Embeddable composite primary key class</li>
		<li>JUnit tests</li>
	</ul>
	<li>Spring Boot</li>
	<ul>
		<li>Repository Interfaces & basic CRUD methods</li>
		<li>Service Interfaces & ServiceImpl Classes</li>
		<li>Optional Objects 
		<li>Query Builder</li>
	</ul>
	<li>JPA</li>
	<li>Hibernate</li>
	<li>MySQL/MySQL Workbench</li>
	<ul>
		<li>Schema/ER Diagram design</li>
		<li>Database creation & placing relationships</li>
		<li>Table inserts & forward engineering changes</li>
	</ul> 
	<li>Postman</li>
	<li>GitHub</li>
	<li>Sublime</li>
	<li>MacOS Terminal/terminal line commands</li>
</ul>

### Lessons Learned
The homework project this week reminded me to slow down and take my time. I ran into errors that were simple typos - like a missing curly brace or backslash in a Request Mapping - and the stack trace in the console didn't seem as useful as before. After slowing down to double check my code before moving onto the next big chunk, I got into a rhythm and made fewer mistakes than before.

Checking in and asking for feedback at important junctures of a project (like confirming my database schema and relationships made sense - which, they didn't and Rob helped me figure out the composite primary key and which fields to put in the join table entity) helped with my time management so I wasn't wasting time on unused code. Receiving guidance on and confirmation of my code provided me with momentum to finish strong.

I feel good about what I completed this weekend - I think I chose the right size project for my skillset, with reasonable user stories. I am curious if my URL mapping seems right, but it was fun seeing my code work on Postman and also using the status codes and stack trace to work through errors and unintended results. It's pretty incredible to see the evolution of our code - and it makes me grateful for those who created frameworks like Spring Data JPA with preloaded query methods, as I know the many involved steps it takes to request and receive data from MySQL.

### Stretch Goals
I accomplished a lot of what I had hoped to with this project. I'm feeling a little less sure of my css and html skills after our group midterm project, so I'm looking forward to seeing how JavaScript fits into the front end of this project next week.
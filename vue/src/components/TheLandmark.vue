<template>
<div>
  <div class="card mb-3">
    <div class= "row g-0">
      <div class="col-md-4">
         <img :src="getImageURL(landmark.landmark_id)">
      </div>
      <div class = "col-md-8">
        <div class="card-body">
          <h5 class = "card-title">{{landmark.landmark_name}}</h5>
          <p class = "card-text">{{landmark.landmark_description}}</p>
        </div>
        
      </div>

    </div>

  </div>
</div>


</template>

<script>

export default {

  

  props: {
    landmark: Object
  },

  methods: {
    getImageURL(id) {
      console.log("../assets/" + id + ".jpg");
      return require("../assets/" + id + ".jpg");
    }
  }


}

</script>

<style scoped>
img {
  max-width: 200px;
}

* {
  box-sizing: border-box;
}

body {
  font-family: Arial, Helvetica, sans-serif;
}

/* Float four columns side by side */
.column {
  float: left;
  width: 25%;
  padding: 0 10px;
}

/* Remove extra left and right margins, due to padding in columns */
.row {margin: 0 -5px;}

/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
}

/* Style the counter cards */
.card {
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2); /* this adds the "card" effect */
  padding: 16px;
  text-align: center;
  background-color: #a08585;
}

/* Responsive columns - one column layout (vertical) on small screens */
@media screen and (max-width: 600px) {
  .column {
    width: 100%;
    display: block;
    margin-bottom: 20px;
  }
}

</style>
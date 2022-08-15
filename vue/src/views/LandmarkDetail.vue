<template>
  <div>
    <the-map
      v-bind:landmark="landmark"
      class="gridItem"
      id="map-container"
    ></the-map>
    <div class="movie_card" id="bright">
       
      <div class="info_section">
        <div class="movie_header">
          <img class="locandina" :src="getImageURL(landmark.landmark_id)" />


          <h1>{{ landmark.landmark_name }}</h1>
         
          <span class="minutes">Address</span>
          <p class="type">{{landmark.street_number}} {{landmark.street_name}} , {{landmark.city_name}}, {{landmark.state_name}}</p>
        </div>
        <div class="movie_desc">
          <p class="text">
           {{ landmark.landmark_description }}
          </p>
        </div>
        <div class="movie_social" >



          <ul>
           <a href="#"> <li><i class="material-icons" @click="showModal" >Add To Itinerary</i></li></a>
            
          </ul>
          
        </div>
      </div>
      
      <div class="blur_back bright_back">
       
      </div>
      

    </div>

    <Modal
            v-bind:landmark="landmark"
            v-show="isModalVisible"
            @close="closeModal"
          >
          </Modal>
  </div>

  
</template>

<script>
import Modal from "../components/itineraryModal.vue";
import LandmarkService from "../services/LandmarkService";
import TheMap from "../components/map.vue";

export default {
  name: "landmark-details",

  data() {
    return {
      isModalVisible: false,
      itinerary: "",
      landmark: "",
    };
  },
  components: {
    TheMap,Modal
  },
  created() {
    LandmarkService.getByID(this.$route.params.id).then((response) => {
      this.landmark = response.data;
    });
  },
  methods: {
    getImageURL(id) {
      console.log("../assets/" + id + ".jpg");
      return require("../assets/" + id + ".jpg");
    },showModal() {
      this.isModalVisible = true;},
      closeModal() {
      this.isModalVisible = false;
    },

    addLandmarkToItinerary() {},
  },
};
</script>

<style scoped>
* {
  box-sizing: border-box;
  margin: 0;
  
}

html,
body {
  margin: 0;
  background: white;
  width: 1020px;
  height: 510px;
  font-family: helvetica, arial, sans-serif;
  font-size: 14px;
  font-weight: 400;
}

.link {
  display: block;
  text-align: center;
  color: #777;
  text-decoration: none;
  padding: 10px;
}
.movie_card {
  position: relative;
  display: block;
  width: 800px;
  height: 350px;
  margin: 80px auto;
  overflow: hidden;
  border-radius: 10px;
  transition: all 0.4s;
  box-shadow:  10px 10px #112740;
}

.movie_card:hover {
  transform: scale(1.02);
  box-shadow: 0px 0px 80px -25px rgba(0, 0, 0, 0.5);
  transition: all 0.4s;
}
.info_section {
  position: relative;
  width: 100%;
  height: 100%;
  background-blend-mode: multiply;
  z-index: 2;
  border-radius: 10px;
}
.movie_header {
  position: relative;
  padding: 25px;
  height: 40%;
}

h1 {
  color: black;
  font-weight: 400;
}
h4 {
  color: #555;
  font-weight: 400;
}
.minutes {
  display: inline-block;
  margin-top: 15px;
  color: #555;
  padding: 5px;
  border-radius: 5px;
  border: 1px solid rgba(0, 0, 0, 0.05);
}
.type {
  display: inline-block;
  color: #959595;
  margin-left: 10px;
}

.locandina {
  position: relative;
  float: left;
  margin-right: 20px;
  height: 120px;
  box-shadow: 0 0 20px -10px rgba(0, 0, 0, 0.5);
}
.movie_desc {
  padding: 25px;
  height: 50%;
}
.text {
  color: #545454;
}

ul {
  list-style: none;
  padding: 0;
  
}

li {
  display: inline-block;
  color: rgba(0, 0, 0, 0.3);
  transition: color 0.3s;
  transition-delay: 0.15s;
  margin: 0 10px;
  background-color: #112740;

  display: inline-block;

  color: rgb(255, 255, 255);
  font-weight: bold;
  padding: 5px;
  border-radius: 5px;
  border: 1px solid rgba(0, 0, 0, 0.05);
}
li:hover {
  transition: color 0.3s;
  background-color: #094181;
}

.movie_social{
  color: #112740;
}

</style>
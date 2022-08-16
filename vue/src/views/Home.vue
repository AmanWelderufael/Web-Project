<template>
  <div class="home">
    <!-- <button @click="toggleShowForm" class="addItineraryButton" href="#">
      Add a new Itinerary
    </button> -->
    <div v-if="itineraries != []">
    <itinerary  v-bind:itinerary ="itinerary" v-for="itinerary in itineraries" v-bind:key="itinerary.itinerary_id"></itinerary>\
    </div>
    <form id="make-itinerary">
      <div class="field">
        <label for="itineraryName">Name of Itinerary</label>
        <input
          type="text"
          name="itineraryName"
          v-model="newItinerary.itinerary_name"
        />
      </div>
      <div class="input-group-mb-3">
        <div class="input-group-prepend">
          <label class="input-group-text" for="inputGroupSelect01"
            >Choose a starting location</label
          >
        </div>
        <select
          v-model="newItinerary.starting_landmark_id"
          class="custom-select"
          id="inputGroupSelect01"
        >
          <option selected>Choose...</option>
          <option
            v-for="landmark in landmarks"
            v-bind:key="landmark.landmark_id"
            v-bind:value="landmark.landmark_id"
          >
            {{ landmark.landmark_name }}
          </option>
        </select>
      </div>
      <button
        type="submit"
        class="btn save"
        v-on:click.prevent="submitItinerary()"
      >
        submit
      </button>
    </form>
  </div>
</template>

<script>
import Itinerary from "../components/Itinerary.vue";

import itineraryService from "../services/ItineraryService";
import LandmarkService from "../services/LandmarkService";
export default {
  components: { Itinerary },

  name: "home",
  data() {
    return {
      showForm: false,
      newItinerary: {
        itinerary_name: "",
        starting_landmark_id: "",
      },
      landmarks: [],
      itineraries: [],
      landmarksOnItineraries: [],
    };
  },
  methods: {
    // toggleShowForm() {
    //   if (this.showForm) {
    //     this.showForm = false;
    //   } else {
    //     this.showForm = true;
    //   }
    // },
    submitItinerary() {
      itineraryService.addItinerary(this.newItinerary);
      this.showForm = false;
      location.reload();
    },
  },
  created() {
    LandmarkService.search().then((response) => {
      this.landmarks = response.data;
    });
    LandmarkService.getByItinerary(this.newItinerary).then((response) => {
      this.landmarks = response.data;
    });
    itineraryService.search().then( (response) => {
       this.itineraries = response.data;
    });
    
  },
};
</script>

<style scoped>
#itinerary {
  width: 25%;
 
}
.home {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  /* background-image:url("../assets/20.jpg") ; */
  background-size: cover;
  background-position: center center;
  display: flex;
  justify-content: space-evenly;
  width: 100%;
  height: 100vh;
}
/* div{
  display: flex;
  
  justify-content: center;
  align-items: center;
} */
#make-itinerary {
  position: absolute;
  top: 50%;
  left: 80%;
  transform: translate(-50%, -50%);
  background: linear-gradient(rgba(0, 0, 0, 0.3), rgba(0, 0, 0, 0.3));
  width: 380px;
  /* padding: 50px 30px; */
  margin: 50px 30px;
  border-radius: 10px;
  box-shadow: 20px 20px 70px rgb(3, 43, 57);
  display: flex;
  flex-direction: column;
  justify-content: space-around;
  height: 50vh;
  align-content: center;
  color: black;
}
.input-group-mb-3 {
  display: flex;
  flex-direction: column;
  flex-shrink: 2;
}
.addItineraryButton {
  /* height: 10vh;
  margin-left: 60px;
  margin-top: 20px;
  transition: 2ms; */
  width: 100px;
  height: 100px;
  background: rgb(79, 85, 88);
  transition: width 1s;
  transition-timing-function: ease-out;
  margin-top: 20px;
  margin-left: 60px;
  border-radius: 20px;
  box-shadow: 10px 10px 30px rgb(3, 43, 57);
  background: linear-gradient(rgba(0, 0, 0, 0.3), rgba(0, 0, 0, 0.3));
  border: none;
}
.addItineraryButton:hover {
  width: 200px;
}
#intro {
  margin: 30px;
}
/* .addItineraryButton{
  display: flex;
  justify-content: center;
  align-content: center;
} */
form {
  position: absolute;
  right: 0;
  width: 100px;
  height: 120px;
  border: 3px solid rgb(30, 30, 68);
}
</style>
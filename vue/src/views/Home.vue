<template>
  <div class="home">
    <button @click="toggleShowForm" class="addItineraryButton" href="#">
      Add a new Itinerary
    </button>
                                                                                                                                                                                                   
    <form id="make-itinerary" v-show="showForm">
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
        <select v-model="newItinerary.starting_landmark_id" class="custom-select" id="inputGroupSelect01">
          <option selected>Choose...</option>
          <option  v-for="landmark in landmarks" v-bind:key="landmark.landmark_id" v-bind:value="landmark.landmark_id">{{landmark.landmark_name}}</option>
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
import itineraryService from "../services/ItineraryService";
import LandmarkService from "../services/LandmarkService";
export default {
  name: "home",
  data() {
    return {
      showForm: false,
      newItinerary: {
        itinerary_name: "",
        starting_landmark_id: ""
      },
      landmarks: [],
    };
  },
  methods: {
    toggleShowForm() {
      if (this.showForm) {
        this.showForm = false;
      } else {
        this.showForm = true;
      }
    },
    submitItinerary() {
      itineraryService.addItinerary(this.newItinerary);
    },
  },
  created() {
    LandmarkService.search().then((response) => {
      this.landmarks = response.data;
    });
  },
};
</script>

<style scoped>
.home{
  margin: 0;
padding: 0;
box-sizing: border-box;
 background-image:url("../assets/20.jpg") ;
 background-size: cover;
 background-position:center center;
 display: flex;
 justify-content: space-evenly;
}
div{
  display: flex;
  width: 100%;
  height: 100vh;
  justify-content: center;
  align-items: center;
}
#make-itinerary{
   position:absolute;
  top:50%;
  left:50%;
  transform: translate(-50%,-50%);
  background: linear-gradient(rgba(0,0,0,0.3),rgba(0,0,0,0.3));
  width: 380px;
  /* padding: 50px 30px; */
  margin: 50px 30px;
  border-radius: 10px;
  box-shadow:7px 7px 60px #000;
  display: flex;
  flex-direction: column;
  justify-content: space-around;
}
.input-group-mb-3{
display: flex;
flex-direction: column;
flex-shrink: 2;
}

#intro {
  margin: 30px;
}
</style>
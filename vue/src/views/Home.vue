<template>
  <div class="home">
    <!-- <button @click="toggleShowForm" class="addItineraryButton" href="#">
      Add a new Itinerary
    </button> -->
    <!-- <div v-if="itineraries != []"> -->
    <itinerary
      class="flex-item"
      v-bind:itinerary="itinerary"
      v-for="itinerary in itineraries"
      v-bind:key="itinerary.itinerary_id"
    ></itinerary
    >\
    <!-- </div> -->

    <form class="flex-item" id="make-itinerary">
      <div class="container">
        <h1 class="sixth">Plan Your Trips</h1>
      </div>
      <div class="field">
        <input
          placeholder="Name of Itinerary"
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
        class="submit"
        v-on:click.prevent="submitItinerary()"
      >
        submit
      </button>

      <router-link class="logo" v-bind:to="{ name: 'LandingPage' }">
        <img class="NYSEE" src="../assets/y.png" alt="NYSEE Logo" />
      </router-link>
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
    itineraryService.search().then((response) => {
      this.itineraries = response.data;
    });
  },
};
</script>

<style scoped>
.home {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  background-size: cover;
  background-position: center center;
  display: flex;

  width: 100%;
  height: 90vh;
}

.flex-item {
  width: 25%;
  margin: 1%;
  height: 80vh;
}
#make-itinerary {
  background: linear-gradient(rgba(194, 81, 81, 0.3), rgba(33, 38, 100, 0.685));
  display: flex;
  flex-direction: column;

  color: whitesmoke;

  border-radius: 10px;
}
.input-group-mb-3 {
  display: flex;
  flex-direction: column;
  flex-shrink: 2;
}

.addItineraryButton {
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

.sixth {
  font-weight: bold;
  color: whitesmoke;

  font-family: "Lato";
}
h1.sixth {
  position: relative;
}
h1.sixth:before,
h1.sixth:after {
  content: "[";
  display: inline-block;
  position: relative;
  top: 1px;
  height: 100%;
  font-size: 1.25em;
  color: tomato;

  transition: all 0.5s ease;
}
h1.sixth:after {
  content: "]";
}

h1.sixth:hover:before {
  transform: translateX(-5px);
}

h1.sixth:hover:after {
  transform: translateX(5px);
}
.field {
  margin-top: 25px;
  display: inline-block;
}
input {
  border: none;
  outline: none;
  display: inline-block;
  height: 34px;
  vertical-align: middle;
  position: relative;
  bottom: 14px;
  right: 9px;
  border-radius: 22px;
  width: 220px;
  box-sizing: border-box;
  padding: 0 18px;
}
.custom-select {
  border: none;
  outline: none;
  display: inline-block;
  height: 34px;
  vertical-align: middle;
  margin-left: 18%;
  bottom: 14px;
  right: 9px;
  border-radius: 22px;
  width: 220px;
  box-sizing: border-box;
  padding: 0 18px;
}

.submit {
  border: none;
  outline: none;
  display: inline-block;
  height: 34px;
  vertical-align: middle;
  position: relative;
  bottom: 14px;
  right: 9px;
  border-radius: 22px;
  width: 220px;
  box-sizing: border-box;
  padding: 0 18px;

  background: #112740 !important;
  color: #fff;
  position: relative;
  left: 35%;
  top: 25px;
  width: 100px;
  cursor: pointer;
}
img {
  border-radius: 50%;
  width: 70%;
  margin-left: auto;
  margin-top: 15%;
}
</style>
const base = {
    get() {
        return {
            url : "http://127.0.0.1:8080/Drivingschool/",
            name: "Drivingschool",
            // exit到Home Page链接
            indexUrl: 'http://127.0.0.1:8080/Drivingschool/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "Driving School Reservation Management System"
        } 
    }
}
export default base

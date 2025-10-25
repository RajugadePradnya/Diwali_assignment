using StudentAPI.Models;
using System.Linq;
using System.Web.Http;

namespace StudentAPI.Controllers
{
    public class StudentsController : ApiController
    {
        private StudentDbContext db = new StudentDbContext();

        [HttpGet]
        [Route("api/students")]
        public IHttpActionResult GetAllStudents()
        {
            return Ok(db.Students.ToList());
        }

        [HttpGet]
        [Route("api/students/{id:int}")]
        public IHttpActionResult GetStudentById(int id)
        {
            var student = db.Students.Find(id);
            if (student == null) return NotFound();
            return Ok(student);
        }

        [HttpGet]
        [Route("api/students/range")]
        public IHttpActionResult GetStudentsByRange(decimal min, decimal max)
        {
            var students = db.Students.Where(s => s.Percentage >= min && s.Percentage <= max).ToList();
            return Ok(students);
        }
    }
}

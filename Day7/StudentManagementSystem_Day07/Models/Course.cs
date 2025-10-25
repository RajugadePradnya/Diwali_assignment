using System.ComponentModel.DataAnnotations;

namespace StudentManagementSystem.Models
{
    public class Course
    {
        [Key]
        public int CourseID { get; set; }

        [Required(ErrorMessage = "Course name is required")]
        [StringLength(100)]
        public string CourseName { get; set; }
    }
}

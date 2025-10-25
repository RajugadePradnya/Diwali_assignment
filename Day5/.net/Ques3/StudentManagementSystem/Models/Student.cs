using System;
using System.ComponentModel.DataAnnotations;

namespace StudentManagementSystem.Models
{
    public class Student
    {
        [Key]
        public int StudentId { get; set; }
        [Required]
        public string Name { get; set; }
        [DataType(DataType.Date)]
        public DateTime BirthDate { get; set; }
        public string Address { get; set; }
        public string SchoolName { get; set; }
        [Range(0,100)]
        public decimal Percentage { get; set; }
    }
}

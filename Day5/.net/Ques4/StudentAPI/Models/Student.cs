using System;
using System.ComponentModel.DataAnnotations;

namespace StudentAPI.Models
{
    public class Student
    {
        [Key]
        public int StudentId { get; set; }

        [Required]
        public string Name { get; set; }

        public DateTime BirthDate { get; set; }

        public string Address { get; set; }

        public string SchoolName { get; set; }

        [Range(0,100)]
        public decimal Percentage { get; set; }
    }
}

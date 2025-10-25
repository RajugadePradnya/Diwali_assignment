using System.Data.Entity;

namespace StudentManagementSystem.Models
{
    public class StudentDbContext : DbContext
    {
        public StudentDbContext() : base("DefaultConnection") { }
        public DbSet<Student> Students { get; set; }
    }
}
